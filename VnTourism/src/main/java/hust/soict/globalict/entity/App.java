package hust.soict.globalict.entity;

import hust.soict.globalict.entity.tourism.natural_attraction.Cave;
import hust.soict.globalict.entity.tourism.natural_attraction.Island;
import hust.soict.globalict.entity.tourism.natural_attraction.Mountain;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       System.out.println("--------------------------------");
//       Lake l1=new Lake();
//       l1.printTurtleFormat(l1.createSparqlQuery(),l1.createFileName());
//       
//       River r1=new River();
//       r1.printTurtleFormat(r1.createSparqlQuery(),r1.createFileName());

//       Bay b1= new Bay();
//       b1.printTurtleFormat(b1.createSparqlQuery(),b1.createFileName());
//       
//       Beach b2= new Beach();
//       b2.printTurtleFormat(b2.createSparqlQuery(),b2.createFileName());
//       Island i1= new Island();
//       i1.printTurtleFormat(i1.createSparqlQuery(),i1.createFileName());
//       	Cave c1= new Cave();
//       	c1.printTurtleFormat(c1.createSparqlQuery(),c1.createFileName());
       
       Mountain m1= new Mountain();
       m1.printTurtleFormat(m1.createSparqlQuery(),m1.createFileName());
       
    }
}
