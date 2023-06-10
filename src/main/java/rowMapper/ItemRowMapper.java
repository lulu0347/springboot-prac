package rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.model.Item;

public class ItemRowMapper implements RowMapper<Item>{

	@Override
	public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Item item = new Item();
		
		item.setItemNo(rs.getInt("itemNo"));
		item.setKindNo(rs.getInt("kindNo"));
		item.setItemName(rs.getString("itemName"));
		item.setItemPrice(rs.getInt("itemPrice"));
		item.setItemState(rs.getInt("itemState"));
		item.setSoldTime(rs.getDate("soldTime"));
		item.setLaunchedTime(rs.getDate("launchedTime"));
		item.setWarrantyDate(rs.getBigDecimal("warrantyDate"));
		item.setItemProdDescription(rs.getString("itemProdDescription"));
		
		return item;
	}
}
