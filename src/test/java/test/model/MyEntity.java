package test.model;

public class MyEntity extends AbstractEntity {

	private String name;
	private String excludeMe;

	private String oneWay;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExcludeMe() {
		return excludeMe;
	}

	public void setExcludeMe(String excludeMe) {
		this.excludeMe = excludeMe;
	}

	public String getOneWay() {
		return oneWay;
	}

	public void setOneWay(String oneWay) {
		this.oneWay = oneWay;
	}
}
