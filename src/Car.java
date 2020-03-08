
public class Car {
	public int year;
	public Integer yearInteger;
	public boolean flag;
	public Boolean flagBoolean;
	
	public Car(int year, Integer yearInteger, boolean flag, Boolean flagBoolean) {
		super();
		this.year = year;
		this.yearInteger = yearInteger;
		this.flag = flag;
		this.flagBoolean = flagBoolean;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Integer getYearInteger() {
		return yearInteger;
	}
	public void setYearInteger(Integer yearInteger) {
		this.yearInteger = yearInteger;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Boolean getFlagBoolean() {
		return flagBoolean;
	}
	public void setFlagBoolean(Boolean flagBoolean) {
		this.flagBoolean = flagBoolean;
	}
	
}
