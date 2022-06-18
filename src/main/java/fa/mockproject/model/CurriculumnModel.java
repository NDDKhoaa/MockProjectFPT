package fa.mockproject.model;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import fa.mockproject.entity.Curriculumn;

public class CurriculumnModel {
	
	private long curriculumnId;
	private String name;
	private String type;
	private byte[] content;
	
	public CurriculumnModel() {
		super();
	}
	
	public CurriculumnModel(long curriculumnId, String name, String type, byte[] content) {
		super();
		this.curriculumnId = curriculumnId;
		this.name = name;
		this.type = type;
		this.content = content;
	}

	public CurriculumnModel(Curriculumn curriculumn) {
		super();
		if (curriculumn == null) 
			return;
		this.curriculumnId = curriculumn.getCurriculumnId();
		this.name = curriculumn.getName();
		this.type = curriculumn.getType();
		this.content = curriculumn.getContent();
	}
	
	public CurriculumnModel(MultipartFile file) throws IOException {
		super();
		if (file == null) 
			return;
		this.name = file.getOriginalFilename();
		this.type = file.getContentType();
		this.content = file.getBytes();
	}

	public long getCurriculumnId() {
		return curriculumnId;
	}

	public void setCurriculumnId(long curriculumnId) {
		this.curriculumnId = curriculumnId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}
