package twg2.arrays.templates;

import java.util.List;

import twg2.template.codeTemplate.ClassTemplate;
import twg2.template.codeTemplate.primitiveTemplate.PrimitiveTypeClassTemplate;

/**
 * @author TeamworkGuy2
 * @since 2014-12-28
 */
public class ArrayInfo extends ClassTemplate {
	public List<Default> types;




	/**
	 * @author TeamworkGuy2
	 * @since 2016-1-17
	 */
	public static class Primitive extends Default {

		public Primitive(boolean doAggregate) {
			super(false, null, " == ", doAggregate);
		}

	}




	/**
	 * @author TeamworkGuy2
	 * @since 2014-12-28
	 */
	public static class Default extends PrimitiveTypeClassTemplate {
		public boolean isGeneric;
		public String genericSignature;
		public String checkEquality;
		public String baseType;


		public Default(boolean isGeneric, String genericSignature, String checkEquality, boolean doAggregate) {
			this.isGeneric = isGeneric;
			this.genericSignature = genericSignature;
			this.checkEquality = checkEquality;
			this.baseType = genericSignature != null && genericSignature.length() > 0 ? "Object" : null;
			super.isAggregatable = doAggregate;
		}


		/**
		 * @param isGeneric true if the type is a generic type
		 * @param defaultValue the default value for this data type
		 * @param genericSignature a generic signature string like {@code <T>} or
		 * {@code <E extends CharSequence>}
		 * @param checkEquality the type of equality check to use when comparing two values
		 * of this type, for example {@code "=="} or {@code ".equals"}
		 * @param doAggregate true to include {@code sum(), avg(), min(), max()} methods for this type
		 */
		public Default(boolean isGeneric, String genericSignature, String checkEquality, boolean doAggregate, String defaultValue) {
			this.isGeneric = isGeneric;
			this.genericSignature = genericSignature;
			this.checkEquality = checkEquality;
			this.baseType = genericSignature != null && genericSignature.length() > 0 ? "Object" : null;
			super.isAggregatable = doAggregate;
			super.defaultValue = defaultValue;
		}


		public String getBaseType() {
			return this.baseType != null ? this.baseType : super.type;
		}


		public String createEqualityCheck(String varName1, String varName2) {
			return varName1 + checkEquality + "(" + varName2 + ")";
		}

	}

}
