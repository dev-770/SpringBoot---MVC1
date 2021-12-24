package hello.itemservice.domain.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Item {

	private Long id;
	private String itemName;
	private Integer price;
	private Integer quantity;
	
	public Item() {
	}
	
}
