package cn.wmj.xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    static Document document=null;
    static Element root=null;
    public static void main( String[] args )
    {

      getDocument();
     // readGrade();
       // addGrade();
       //updateGrade();
        delGrade();
    }

    //删除节点
    private static void delGrade() {
        Iterator<Element> grades = root.elementIterator();
        while(grades.hasNext()){
            Element grade = grades.next();
            if (grade.attributeValue("name").equals("3班")){

                root.remove(grade);
            }
            SaveXML();
        }
    }

    //修改节点
    private static void updateGrade() {
        Iterator<Element> grades = root.elementIterator();
        while(grades.hasNext()){
            Element grade = grades.next();
            Iterator<Element> claaa = grade.elementIterator();
            while (claaa.hasNext()){
                Element student = claaa.next();
                if (student.attributeValue("id").equals("2")){
                    student.setText("小黑黑");

                }
            }
            SaveXML();
        }
    }


    //添加节点
    private static void addGrade() {
        Element clazz = root.addElement("class");
        clazz.setAttributeValue("name","3班");

        Element student = clazz.addElement("student");
        student.setAttributeValue("id","1");
        student.setText("小红1");

        Element student2= clazz.addElement("student");
        student2.setAttributeValue("id","2");
        student2.setText("小红2");

        SaveXML();
    }
    private static void SaveXML(){
        XMLWriter writer=null;
        OutputFormat fomart=null;


        try {
            fomart=OutputFormat.createPrettyPrint();
            writer=new XMLWriter(new FileWriter("src/grade"),fomart);
            writer.write(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
       finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }



    //获取根节点和子节点
    private static void getDocument() {
        SAXReader reader=new SAXReader();
        try {
            document=  reader.read("src/grade");
            root=document.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }


    //读取XML
    private static void readGrade() {
        Iterator<Element> grades = root.elementIterator();
        while (grades.hasNext()){
            Element grade = grades.next();
            System.out.println(grade.attributeValue("name"));
            Iterator<Element> ids = grade.elementIterator();
            while (ids.hasNext()){
                Element id = ids.next();
                System.out.println(id.attributeValue("id"));
                System.out.println(id.getTextTrim());

            }
        }

    }




}
