package com.dakor.portal.rest;

import com.sun.jersey.spi.resource.Singleton;
import org.apache.commons.io.IOUtils;

import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Date;

/**
 * @author dkor
 */
@Path("media")
@Singleton
public class MediaResource {

	/** 1MB chunks */
	private static final int CHUNK_SIZE = 1024 * 1024;

	@GET
	@Path("audio")
	@Produces("audio/mp3")
	public Response streamAudio(@HeaderParam("Range") String range) throws Exception {
		File audio = new File("d:\\Music\\13 Dreamer.mp3");

		return buildStream(audio, range);
	}

	@GET
	@Path("video")
	@Produces("video/mpeg")
	public Response streamVideo(@HeaderParam("Range") String range) throws Exception {
		File audio = new File("d:\\video\\21062012007.mp4");

		return buildStream(audio, range);
	}

	/**
	 *
	 *
	 * @param mediaFile Media file
	 * @param range range header
	 * @return Streaming output
	 * @throws Exception IOException if an error occurs in streaming.
	 */
	private Response buildStream(final File mediaFile, final String range) throws Exception {
		// range not requested : Firefox, Opera, IE do not send range headers
		if (range == null) {
			StreamingOutput streamer = new StreamingOutput() {
				@Override
				public void write(final OutputStream output) throws IOException {
					FileChannel inputChannel = null;
					WritableByteChannel outputChannel = null;
					try {
						inputChannel = new FileInputStream(mediaFile).getChannel();
						outputChannel = Channels.newChannel(output);

						inputChannel.transferTo(0, inputChannel.size(), outputChannel);
					} finally {
						IOUtils.closeQuietly(inputChannel);
						IOUtils.closeQuietly(outputChannel);
					}
				}
			};

			return Response.ok(streamer).status(200).header(HttpHeaders.CONTENT_LENGTH, mediaFile.length()).build();
		}

		String[] ranges = range.split("=")[1].split("-");
		final int from = Integer.parseInt(ranges[0]);

		// chunk media if the range upper bound is unspecified. Chrome sends "bytes=0-"
		int to = CHUNK_SIZE + from;
		if (to >= mediaFile.length()) {
			to = (int) (mediaFile.length() - 1);
		}
		if (ranges.length == 2) {
			to = Integer.parseInt(ranges[1]);
		}

		final String responseRange = String.format("bytes %d-%d/%d", from, to, mediaFile.length());
		final RandomAccessFile raf = new RandomAccessFile(mediaFile, "r");
		raf.seek(from);

		final int len = to - from + 1;
		final MediaStreamer streamer = new MediaStreamer(len, raf);
		Response.ResponseBuilder res = Response.ok(streamer).status(206)
				.header("Accept-Ranges", "bytes")
				.header("Content-Range", responseRange)
				.header(HttpHeaders.CONTENT_LENGTH, streamer.getLenth())
				.header(HttpHeaders.LAST_MODIFIED, new Date(mediaFile.lastModified()));
		return res.build();
	}

}
