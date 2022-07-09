package fa.mockproject.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public class MultipartFileImpl implements MultipartFile {

	private byte[] content;
	private String name;
	private String contentType;
	
	public MultipartFileImpl(byte[] content, String name, String contentType) {
		super();
		this.content = content;
		this.name = name;
		this.contentType = contentType;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getOriginalFilename() {
		return this.name;
	}

	@Override
	public String getContentType() {
		return this.contentType;
	}

	@Override
	public boolean isEmpty() {
		return this.content == null || this.content.length == 0;
	}

	@Override
	public long getSize() {
		return this.content.length;
	}

	@Override
	public byte[] getBytes() throws IOException {
		return this.content;
	}

	@Override
	public InputStream getInputStream() throws IOException {
		return new ByteArrayInputStream(content);
	}

	@Override
	public void transferTo(File dest) throws IOException, IllegalStateException {
		try (FileOutputStream f = new FileOutputStream(dest)) {
			f.write(content);
		}
	}

}
