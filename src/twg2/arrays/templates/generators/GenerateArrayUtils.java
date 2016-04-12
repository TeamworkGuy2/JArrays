package twg2.arrays.templates.generators;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.stringtemplate.v4.ST;

import twg2.arrays.templates.ArrayInfo;
import twg2.template.codeTemplate.primitiveTemplate.PrimitiveTemplates;
import twg2.template.codeTemplate.render.STTemplates;
import twg2.template.codeTemplate.render.TemplateImports;
import twg2.template.codeTemplate.render.TemplateRenderBuilder;

/**
 * @author TeamworkGuy2
 * @since 2014-12-28
 */
public class GenerateArrayUtils {
	private static String tmplDir = "src.twg2.arrays.templates".replace('.', '/') + '/';
	private static TemplateImports importsMapper = TemplateImports.emptyInst();
	private static ArrayInfo.Default genericType = new ArrayInfo.Default(true, "<T>", ".equals", false, "null");
	private static List<ArrayInfo.Default> aryTypes;

	static {
		genericType.type = "T";

		aryTypes = Arrays.asList(
			PrimitiveTemplates.newBooleanTemplate(new ArrayInfo.Primitive(false), null, null),
			PrimitiveTemplates.newByteTemplate(new ArrayInfo.Primitive(true), null, null),
			PrimitiveTemplates.newShortTemplate(new ArrayInfo.Primitive(true), null, null),
			PrimitiveTemplates.newCharTemplate(new ArrayInfo.Primitive(true), null, null),
			PrimitiveTemplates.newIntTemplate(new ArrayInfo.Primitive(true), null, null),
			PrimitiveTemplates.newLongTemplate(new ArrayInfo.Primitive(true), null, null),
			PrimitiveTemplates.newFloatTemplate(new ArrayInfo.Primitive(true), null, null),
			PrimitiveTemplates.newDoubleTemplate(new ArrayInfo.Primitive(true), null, null),
			genericType
		);
	}


	public static final void generateArrayUtil() throws IOException {
		ArrayInfo info = new ArrayInfo();
		info.className = "ArrayUtil";
		info.packageName = "twg2.arrays";

		info.types = aryTypes;

		ST stTmpl = STTemplates.fromFile(tmplDir + "TArrayUtil.stg", "TArrayUtil", importsMapper);
		TemplateRenderBuilder.newInst()
				.addParam("var", info)
				.writeDst(info)
				.render(stTmpl);
	}


	public static void main(String[] args) throws IOException {
		generateArrayUtil();
	}

}
