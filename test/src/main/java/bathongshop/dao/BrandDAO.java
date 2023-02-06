package bathongshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bathongshop.constant.PublicConstant;
import bathongshop.entity.Brand;
import bathongshop.jdbcutil.JDBCUtil;

public class BrandDAO {
	private static Logger logger = LogManager.getLogger(BrandDAO.class);
	private static BrandDAO brandDAO = null;

	public static BrandDAO getBrandDAO() {
		if (brandDAO == null) {
			brandDAO = new BrandDAO();
		}
		return brandDAO;
	}

	public List<Brand> selectAllBrands() {
		List<Brand> brands = new ArrayList<>();
		try (Connection connection = JDBCUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(PublicConstant.SELECT_ALL_BRAND);) {
			logger.info(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(PublicConstant.ID);
				String name = rs.getString(PublicConstant.NAME_COLUMN);
				brands.add(new Brand(id, name));
			}
		} catch (Exception e) {
			logger.error(PublicConstant.THIS_IS_ERROR, e.getMessage());
		}
		return brands;
	}
}
