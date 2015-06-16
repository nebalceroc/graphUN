public class CanvasShape{
	private Object obj;
	private String type;
	private String props;
	public CanvasShape(Object obj,String type){
		this.obj = obj;
		this.type = type;
	}
	public CanvasShape(String type){
		this.obj = null;
		this.type = type;
	}
	public Object getObj(){
		return this.obj;
	}
	public String getType(){
		return this.type;
	}
	public String getProps(){
		return this.props;
	}
	public void setObj(Object obj){
		this.obj = obj;
	}
	public void setType(String type){
		this.type = type;
	}
	public void setProps(String props){
		this.props = props;
	}
	
}