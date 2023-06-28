package dto;

public class ProductDto {
	String product_name, detail, product_size, reg_company, priority, attach, reg_id, reg_date;
	int price, hit;
	public ProductDto(String product_name, String detail, String product_size, String reg_company, String priority,
			String attach, String reg_id, String reg_date, int price, int hit) {
		super();
		this.product_name = product_name;
		this.detail = detail;
		this.product_size = product_size;
		this.reg_company = reg_company;
		this.priority = priority;
		this.attach = attach;
		this.reg_id = reg_id;
		this.reg_date = reg_date;
		this.price = price;
		this.hit = hit;
	}
	public String getProduct_name() {
		return product_name;
	}
	public String getDetail() {
		return detail;
	}
	public String getProduct_size() {
		return product_size;
	}
	public String getReg_company() {
		return reg_company;
	}
	public String getPriority() {
		return priority;
	}
	public String getAttach() {
		return attach;
	}
	public String getReg_id() {
		return reg_id;
	}
	public String getReg_date() {
		return reg_date;
	}
	public int getPrice() {
		return price;
	}
	public int getHit() {
		return hit;
	}

	
	
	
	
}
