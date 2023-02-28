
## 🚀 About Me
I am a full stack developer (although with some difficulties in the front-end :D) in java, I have almost 5 years in the language and I am currently transitioning to cybersecurity, specifically pentesting. I am very responsible and efficient and among my greatest virtues I consider that my learning abilities are much higher than average. I have many goals for the future but I am not in a hurry to fulfill them because I know that I will get to do it. Oh and my name is Julio David Trigo Medina


## 🔗 Links

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/julio-trigo-56223a144/)
[![twitter](https://img.shields.io/badge/twitter-1DA1F2?style=for-the-badge&logo=twitter&logoColor=white)](https://twitter.com/Zaxkiro)


# intrusion detector in a local network

This is my degree project. A program elaborated in java with the use of "Sockets" where possible viruses and/or intruders are detected in a machine to automatically cut connections so that it cannot access other machines


## Documentation

[graduation project](https://docs.google.com/document/d/1G_amMDfCfTiIKfBJg_4YbMiV_4_URWSm/edit?usp=sharing&ouid=113078933759615131334&rtpof=true&sd=true)


## FAQ

#### It can improve?

Yes, it has several bugs and room for improvement, such as in the front-end part or the pseudo-anti virus

#### Can people use the code?

of course not. Just kidding, of course anyone can use it


## Installation

it just downloads both the "control" class and the "TerminalCliente" class.

and for the database you have to do the following:

Note: It is sql server

```java
package your project;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public static Connection getConexion(){
        
        String conexionUrl = "jdbc:sqlserver://your user\\SQLEXPRESS:1433;"
                + "database=your database;"
                + "user=your user;"
                + "password=your password;";
        
        try{
            Connection xion = DriverManager.getConnection(conexionUrl);
            return xion;
        } catch(SQLException ex){
            System.out.println(ex.toString());
            return null;
        }
        
    }
    
}
```
    