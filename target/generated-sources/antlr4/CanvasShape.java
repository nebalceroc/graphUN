public class CanvasShape{
	private Object obj;
	private String id;
	private String type;
	private String color;
	private String fill;
	private String border;
	private float cy;
	private float cx;
	private float p1;
	private float p2;
	private float p3;
	private float p4;
	private float rotation;

	public CanvasShape(Object obj,String type){
		this.obj = obj;
		this.type = type;
	}
	public CanvasShape(String type){
		this.obj = null;
		this.type = type;
		this.id= "no_id";
		this.cx=100;
		this.cy=100;
		this.p1=200;
		this.p2=200;
		this.p3=500;
		this.p4=500;
		this.color="no_color";
		this.fill="white";
		this.border="black";
		this.rotation=0;
	}
	public Object getObj(){
		return this.obj;
	}
	public String getType(){
		return this.type;
	}
	public String getId(){
		return this.id;
	}
	public String getBorder(){
		return this.border;
	}
	public String getFill(){
		return this.fill;
	}
	public String getColor(){
		return this.color;
	}
	public float getP1(){
		return this.p1;
	}
	public float getP2(){
		return this.p2;
	}
	public float getP3(){
		return this.p3;
	}
	public float getP4(){
		return this.p4;
	}
	public float getRotation(){
		return this.rotation;
	}
	public float getCx(){
		return this.cx;
	}
	public float getCy(){
		return this.cy;
	}
	
	public void setObj(Object obj){
		this.obj = obj;
	}
	public void setType(String type){
		this.type = type;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setBorder(String border){
		this.border = border;
		this.color  = "no_color";
	}
	public void setFill(String fill){
		this.fill = fill;
		this.color  = "no_color";
	}
	public void setColor(String color){
		this.color = color;
		this.border  = color;
		this.fill  = color;
	}
	public void setP1(float p1){
		this.p1 = p1;
	}
	public void setP2(float p2){
		this.p2 = p2;
	}
	public void setP3(float p3){
		this.p3 = p3;
	}
	public void setP4(float p4){
		this.p4 = p4;
	}
	public void setRotation(float rotation){
		this.rotation = rotation;
	}
	public void setCx(float cx){
		this.cx = cx;
	}
	public void setCy(float cy){
		this.cy = cy;
	}
	
	
}