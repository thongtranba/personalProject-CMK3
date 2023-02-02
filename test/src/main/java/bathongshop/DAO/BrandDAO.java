package bathongshop.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bathongshop.JDBCUtil.JDBCUtil;
import bathongshop.constant.PublicConstant;
import bathongshop.entity.Brand;

public class BrandDAO {
	public List<Brand> selectAllBrands() {
		List<Brand> brands = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(PublicConstant.SELECT_ALL_BRAND);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				brands.add(new Brand(id, name));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return brands;
	}
}
