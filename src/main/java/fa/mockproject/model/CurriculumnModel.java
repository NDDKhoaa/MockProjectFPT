package fa.mockproject.model;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

import fa.mockproject.entity.Curriculumn;
import fa.mockproject.util.MultipartFileImpl;

public class CurriculumnModel {
	
	private long curriculumnId;
	private String name;
	private String type;
	private byte[] content;
	private MultipartFile file;
	private long updateState;
	
	public CurriculumnModel() {
		super();
	}
	
	public CurriculumnModel(long curriculumnId, String name, String type, byte[] content, long updateState) {
		super();
		this.curriculumnId = curriculumnId;
		this.name = name;
		this.type = type;
		this.content = content;
		this.updateState = updateState;
	}

	public CurriculumnModel(Curriculumn curriculumn) {
		super();
		if (curriculumn == null) 
			return;
		this.curriculumnId = curriculumn.getCurriculumnId();
		this.name = curriculumn.getName();
		this.type = curriculumn.getType();
		this.content = curriculumn.getContent();
		this.file = new MultipartFileImpl(content, name, type);
	}
	
	public CurriculumnModel(MultipartFile file) throws IOException {
		super();
		if (file == null) 
			return;
		this.name = file.getOriginalFilename();
		this.type = file.getContentType();
		this.content = file.getBytes();
		this.file = file;
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
	
	public void setFile(MultipartFile file) throws IOException {
		if (file == null) 
			return;
		this.name = file.getOriginalFilename();
		this.type = file.getContentType();
		this.content = file.getBytes();
		this.file = file;
	}
	
	public MultipartFile getFile() {
		return this.file;
	}

	public long getUpdateState() {
		return updateState;
	}

	public void setUpdateState(long updateState) {
		this.updateState = updateState;
	}

	@Override
	public String toString() {
		return "CurriculumnModel [curriculumnId=" + curriculumnId + ", name=" + name + ", type=" + type + ", content="
				+ content.length + ", updateState=" + updateState + "]";
	}

	

}
