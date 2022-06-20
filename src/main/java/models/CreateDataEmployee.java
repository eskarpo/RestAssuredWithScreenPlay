package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class CreateDataEmployee {

	@SerializedName("name")
	@Expose
	public String name;

	@SerializedName("salary")
	@Expose
	public String  salary;

	@SerializedName("age")
	@Expose
	public String age;


	public CreateDataEmployee(){
		this.name = "";
		this.salary = "";
		this.age = "";
	}
}
