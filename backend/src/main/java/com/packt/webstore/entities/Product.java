package com.packt.webstore.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;

	@ManyToMany
	@JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	Set<Category> categories = new HashSet<>();

	public Product() {

		super();
	}

	public Product(Long id, String sku, String name, BigDecimal unitPrice, String manufacturer, long unitsInStock,
			long unitsInOrder, String description, boolean discontinued, String condition, Instant createdAt,
			Instant updatedAt) {
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
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
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

	public Set<Category> getCategories() {

		return categories;
	}

	public Instant getCreatedAt() {

		return createdAt;
	}

	public Instant getUpdatedAt() {

		return updatedAt;
	}

	@PrePersist
	public void prePersist() {

		createdAt = Instant.now();
	}

	@PreUpdate
	public void preUpdate() {

		updatedAt = Instant.now();
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}