package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class DeleteDataEmployee {

	@SerializedName("id")
	@Expose
	public String id;

	@SerializedName("status")
	@Expose
	public String  status;

	@SerializedName("message")
	@Expose
	public String message;


	public DeleteDataEmployee(){
		this.id = "";
		this.status = "";
		this.message = "";
	}
}
