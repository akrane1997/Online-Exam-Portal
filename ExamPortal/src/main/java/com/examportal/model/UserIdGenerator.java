package com.examportal.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UserIdGenerator implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		String prefix = "USER";
		Connection connection =session.connection();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet rs=statement.executeQuery("select count(user_Id) as user_Id from User");
			
			if(rs.next())
            {
                int id=rs.getInt(1)+101;
                String generatedId = prefix + new Integer(id).toString();
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } 
		catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		
		return null;
	}

}
