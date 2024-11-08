import java.util.LinkedList;

public class Transition {
	
	private LinkedList<EdgeIn> edgesIn;
	private LinkedList<EdgeOut> edgesOut;
	
	public Transition() {
		edgesIn = new  LinkedList<EdgeIn>();
		edgesOut = new  LinkedList<EdgeOut>();
	}
	
	public boolean isFireable() {
		boolean test = true;
		for (EdgeIn ei : edgesIn) {
			if (!ei.isFireable()) {
				test = false;
			}
		}
		return test;
	}

	public LinkedList<EdgeIn> getEdgesIn() {
		return edgesIn;
	}

	public void setEdgesIn(LinkedList<EdgeIn> edgesIn) {
		this.edgesIn = edgesIn;
	}

	public LinkedList<EdgeOut> getEdgesOut() {
		return edgesOut;
	}

	public void setEdgesOut(LinkedList<EdgeOut> edgesOut) {
		this.edgesOut = edgesOut;
	}

	public void fire() {
		for (EdgeIn ei : edgesIn) {
			ei.fire();
		}
		for (EdgeOut eo : edgesOut) {
			eo.fire();
		}
	}
	

}
