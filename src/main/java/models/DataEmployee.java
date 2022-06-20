package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class DataEmployee {

	@SerializedName("suId")
	@Expose
	public String suId;

	@SerializedName("id")
	@Expose
	public String id;

	@SerializedName("employeeName")
	@Expose
	public String  employeeName;

	@SerializedName("employeeSalary")
	@Expose
	public String employeeSalary;

	@SerializedName("employeeAge")
	@Expose
	public String employeeAge;

	public DataEmployee(){
		this.suId = "";
		this.id = "";
		this.employeeName = "";
		this.employeeSalary = "";
		this.employeeAge = "";
	}
}
