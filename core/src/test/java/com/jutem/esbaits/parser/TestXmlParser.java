package com.jutem.esbaits.parser;

import com.jutem.esbatis.parser.XmlParser;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TestXmlParser {
    @Test
    public void testXmlParser() throws FileNotFoundException {
        XmlParser parser = new XmlParser();
        String path = TestXmlParser.class.getClassLoader().getResource("mapper/TestXmlParser.xml").getPath();
        System.out.println(path);

        FileInputStream fis = new FileInputStream(new File(path));
        Document doc = parser.createDocument(new InputSource(fis));

        Element root =  doc.getDocumentElement();
        Assert.assertEquals("root 元素获取错误", "mapper", root.getTagName());
        Node resultMap = root.getChildNodes().item(0);
        Assert.assertEquals("resultMap 获取错误", "resultMap", resultMap.getNodeName());
        Node property = resultMap.getChildNodes().item(0);
        String term = property.getAttributes().getNamedItem("term").getNodeValue();
        Assert.assertEquals("property 属性获取错误", "id", term);
    }


}
