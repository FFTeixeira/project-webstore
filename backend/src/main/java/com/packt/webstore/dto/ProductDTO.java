package com.packt.webstore.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.packt.webstore.entities.Category;
import com.packt.webstore.entities.Product;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String sku;
	private String name;
	private BigDecimal unitPrice;
	private String manufacturer;
	private long unitsInStock;
	private long unitsInOrder;
	private String description;
	private boolean discontinued;
	private String condition;

	private List<CategoryDTO> categories = new ArrayList<>();

	public ProductDTO() {
		super();
	}

	public ProductDTO(Long id, String sku, String name, BigDecimal unitPrice, String manufacturer, long unitsInStock,
			long unitsInOrder, String description, boolean discontinued, String condition) {

		super();
		this.id = id;
		this.sku = sku;
		this.name = name;
		this.unitPrice = unitPrice;
		this.manufacturer = manufacturer;
		this.unitsInStock = unitsInStock;
		this.unitsInOrder = unitsInOrder;
		this.description = description;
		this.discontinued = discontinued;
		this.condition = condition;
	}

	public ProductDTO(Product entity) {

		super();
		id = entity.getId();
		sku = entity.getSku();
		name = entity.getName();
		unitPrice = entity.getUnitPrice();
		manufacturer = entity.getManufacturer();
		unitsInStock = entity.getUnitsInStock();
		unitsInOrder = entity.getUnitsInOrder();
		description = entity.getDescription();
		discontinued = entity.isDiscontinued();
		condition = entity.getCondition();
	}

	public ProductDTO(Product entity, Set<Category> categories) {

		this(entity);

		categories.forEach(cat -> this.categories.add(new CategoryDTO(cat)));
	}

	public Long getId() {

		return id;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public String getSku() {

		return sku;
	}

	public void setSku(String sku) {

		this.sku = sku;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public BigDecimal getUnitPrice() {

		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {

		this.unitPrice = unitPrice;
	}

	public String getManufacturer() {

		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {

		this.manufacturer = manufacturer;
	}

	public long getUnitsInStock() {

		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {

		this.unitsInStock = unitsInStock;
	}

	public long getUnitsInOrder() {

		return unitsInOrder;
	}

	public void setUnitsInOrder(long unitsInOrder) {

		this.unitsInOrder = unitsInOrder;
	}

	public String getDescription() {

		return description;
	}

	public void setDescription(String description) {

		this.description = description;
	}

	public boolean isDiscontinued() {

		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {

		this.discontinued = discontinued;
	}

	public String getCondition() {

		return condition;
	}

	public void setCondition(String condition) {

		this.condition = condition;
	}

	public List<CategoryDTO> getCategories() {
		
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		
		this.categories = categories;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}