package org.repository.domain.library;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * LibraryConfig domain class
 *
 */
@Entity
@Table(name = "LibraryConfig",uniqueConstraints={@UniqueConstraint(columnNames = {"category","name","accessLevel"})}) 
public class LibraryConfig implements Serializable {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id = 0L;
	
	String category;
    String name;
    String accessLevel;
    
    ValueType valueType;
	String value;
    Integer intValue;
    Double  doubleValue;
    Boolean booleanValue;
    
    /**
	 * Default Constructor
	 *
	 */
    public LibraryConfig(){
    	
    }
    
	/**
	 * 
	 * LibraryConfig Constructor
	 * 
	 * @param category
	 * @param name
	 * @param accessLevel
	 * @param valueType
	 * @param value
	 * @param intValue
	 * @param doubleValue
	 * @param booleanValue
	 */
	public LibraryConfig(String category, String name, String accessLevel, ValueType valueType, String value,
			Integer intValue, Double doubleValue, Boolean booleanValue) {
		super();
		this.category = category;
		this.name = name;
		this.accessLevel = accessLevel;
		this.valueType = valueType;
		this.value = value;
		this.intValue = intValue;
		this.doubleValue = doubleValue;
		this.booleanValue = booleanValue;
	}
	
	
	/**
	 * 
	 * LibraryConfig Constructor
	 * 
	 * @param category
	 * @param name
	 * @param accessLevel
	 * @param valueType
	 * @param value
	 * @param intValue
	 * @param doubleValue
	 * @param booleanValue
	 */
	public LibraryConfig(Long id,String category, String name, String accessLevel, ValueType valueType, String value,
			Integer intValue, Double doubleValue, Boolean booleanValue) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.accessLevel = accessLevel;
		this.valueType = valueType;
		this.value = value;
		this.intValue = intValue;
		this.doubleValue = doubleValue;
		this.booleanValue = booleanValue;
	}
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	public ValueType getValueType() {
		return valueType;
	}

	public void setValueType(ValueType valueType) {
		this.valueType = valueType;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Integer getIntValue() {
		return intValue;
	}
	public void setIntValue(Integer intValue) {
		this.intValue = intValue;
	}
	public Double getDoubleValue() {
		return doubleValue;
	}
	public void setDoubleValue(Double doubleValue) {
		this.doubleValue = doubleValue;
	}
	public Boolean getBooleanValue() {
		return booleanValue;
	}
	public void setBooleanValue(Boolean booleanValue) {
		this.booleanValue = booleanValue;
	}

	@Override
	public String toString() {
		return "LibraryConfig [id=" + id + ", category=" + category + ", name=" + name + ", accessLevel=" + accessLevel
				+ ", valueType=" + valueType + ", value=" + value + ", intValue=" + intValue + ", doubleValue="
				+ doubleValue + ", booleanValue=" + booleanValue + "]";
	}  
}
