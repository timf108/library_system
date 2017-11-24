package org.repository.domain.library;

import java.io.Serializable;

public class LibraryConfigVO implements Serializable {
	  
		String category;
	    String name;
	    
	    //"" means global level , null empty means branch name
	    String accessLevel;
	    
	    ValueType valueType;
	    String value;
	    int intValue;
	    double  doubleValue;
	    boolean booleanValue;
	    
	    /**
		 * Default Constructor
		 *
		 */
	    public LibraryConfigVO(){
	    	
	    }
	    
	    
	    
	    /**
		 *  Constructor
		 *
		 */
		public LibraryConfigVO(String category, String name, String accessLevel, ValueType valueType, String value,
				int intValue, double doubleValue, boolean booleanValue) {
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


		public int getIntValue() {
			return intValue;
		}


		public void setIntValue(int intValue) {
			this.intValue = intValue;
		}


		public double getDoubleValue() {
			return doubleValue;
		}


		public void setDoubleValue(double doubleValue) {
			this.doubleValue = doubleValue;
		}


		public boolean isBooleanValue() {
			return booleanValue;
		}


		public void setBooleanValue(boolean booleanValue) {
			this.booleanValue = booleanValue;
		}

		
		public static LibraryConfigVO fromEntity(LibraryConfig entity) {
			LibraryConfigVO vo = new LibraryConfigVO(entity.getCategory(), entity.getName(), entity.getAccessLevel(), entity.getValueType(), entity.getValue(),
					entity.getIntValue(), entity.getDoubleValue(), entity.getBooleanValue());		
			return vo;	
		}
		
		public static LibraryConfig toEntity(LibraryConfigVO vo) {
			LibraryConfig en = new LibraryConfig(vo.getCategory(), vo.getName(), vo.getAccessLevel(), vo.getValueType(), vo.getValue(),
					vo.getIntValue(), vo.getDoubleValue(), vo.isBooleanValue());
			
			ValueType valueType = vo.getValueType();
			if (valueType != null) {
				if (valueType == ValueType.Boolean) {
					en.setBooleanValue(Boolean.valueOf(vo.getValue()));
				} else if (valueType == ValueType.Int) {
					en.setIntValue(Integer.valueOf(vo.getValue()));
				} else if (valueType == ValueType.Double) {
					en.setDoubleValue(Double.valueOf(vo.getValue()));
				}
			}
			
			return en;	
		}
		

		@Override
		public String toString() {
			return "LibraryConfigVO [category=" + category + ", name=" + name + ", accessLevel=" + accessLevel
					+ ", valueType=" + valueType + ", value=" + value + ", intValue=" + intValue + ", doubleValue="
					+ doubleValue + ", booleanValue=" + booleanValue + "]";
		}

}
