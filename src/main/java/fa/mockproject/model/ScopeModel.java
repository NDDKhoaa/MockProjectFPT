package fa.mockproject.model;

import fa.mockproject.entity.Scope;

public class ScopeModel {
	
	private long scopeId;
	private String scopeName;
	private String remarks;
	
	public ScopeModel() {
		super();
	}
	
	public ScopeModel(long scopeId, String scopeName, String remarks) {
		super();
		this.scopeId = scopeId;
		this.scopeName = scopeName;
		this.remarks = remarks;
	}
	
	public ScopeModel(Scope scope) {
		super();
		this.scopeId = scope.getScopeId();
		this.scopeName = scope.getScopeName();
		this.remarks = scope.getRemarks();
	}

	public long getScopeId() {
		return scopeId;
	}

	public void setScopeId(long scopeId) {
		this.scopeId = scopeId;
	}

	public String getScopeName() {
		return scopeName;
	}

	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "ScopeModel [scopeId=" + scopeId + ", scopeName=" + scopeName + ", remarks=" + remarks + "]";
	}
	
}
