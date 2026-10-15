import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class Dom {
    static void walk(Node n, int depth) {                       // preorder over the DOM
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element e = (Element) n;
            String attr = e.hasAttribute("id") ? " id=" + e.getAttribute("id") : "";
            System.out.println("  ".repeat(depth) + e.getTagName() + attr);
        }
        for (Node c = n.getFirstChild(); c != null; c = c.getNextSibling())   // first child, next sibling!
            walk(c, depth + 1);
    }

    static Document parse(String xml) throws Exception {
        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        f.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);   // security
        return f.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));
    }

    public static void main(String[] args) throws Exception {
        String xml = "<course id='CSE211'><week id='1'><topic/><lab/></week><week id='2'><topic/></week></course>";
        walk(parse(xml).getDocumentElement(), 0);

        String evil = "<?xml version='1.0'?><!DOCTYPE x [<!ENTITY e SYSTEM 'file:///etc/passwd'>]><x>&e;</x>";
        try {
            parse(evil);
        } catch (Exception e) {
            System.out.println("rejected: " + e.getMessage().replaceAll("\\s+", " ").substring(0, 60) + "...");
        }
    }
}
