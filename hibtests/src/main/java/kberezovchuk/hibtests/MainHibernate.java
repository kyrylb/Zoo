package kberezovchuk.hibtests;

import java.util.List;
import kberezovchuk.hibtests.entities.Permission;
import kberezovchuk.hibtests.entities.User;
import kberezovchuk.hibtests.types.PermissionType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class MainHibernate {

    /*
        Reference:
        https://github.com/hibernate/hibernate-orm/blob/master/hibernate-testing/src/main/java/org/hibernate/testing/junit4/BaseCoreFunctionalTestCase.java
    */
    public static void main(String[] args) {
        Configuration configuration = new Configuration().configure();

        configuration
                .addAnnotatedClass(Permission.class)
                .addAnnotatedClass(User.class);


        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        // obtains the session
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Check database version
        String sql = "select version()";
        List<String> results = session.createSQLQuery(sql).list();
        System.out.println(results.get(0));


        User user = session.get(User.class, 24);
        session.delete(user);

        //Permission permission = session.get(Permission.class, 15);
        //session.delete(permission);

/*
        User user = new User();
        user.setName("Test33");
        user.setToken("agaga"+ System.nanoTime());


        Permission permission = new Permission();
        permission.setType(PermissionType.MERCHANT_SEARCH_WITH_ATTR_DOCUMENTS);
        permission.setInstanceId(3000);
        session.save(permission);

        Permission permission2 = new Permission();
        permission2.setType(PermissionType.MERCHANT_DOCUMENTS_INFO);
        permission2.setInstanceId(4000);
        session.save(permission2);

        user.getPermissions().add(permission);
        user.getPermissions().add(permission2);
        session.save(user);
*/

/*
        session.get(User.class, 34).getPermissions().add(session.get(Permission.class, 13));
        session.get(User.class, 30).getPermissions().add(session.get(Permission.class, 14));
*/

        //Permission permission2 =  session.get(Permission.class, 13);
        //session.delete(permission2);

        //permission2.getUsers().remove(session.get(User.class, 34));


        /*
        Permission permission2 =  session.get(Permission.class, 17);

        User user = new User();
        user.setName("Test1");
        user.setToken("ababa"+ System.nanoTime());
        session.save(user);

        user.getPermissions().add(permission2);
        */

        /*
        // Save some entities
        Permission permission = new Permission();
        permission.setType(PermissionType.MERCHANT_SEARCH_WITH_ATTR_DOCUMENTS);
        permission.setInstanceId(1000);
        session.save(permission);


        //





        User user2 =  (User) session.get(User.class, 25);
        user2.getPermissions().add(permission);
        ((User) session.get(User.class, 26)).getPermissions().add(permission);
        ((User) session.get(User.class, 27)).getPermissions().add(permission);
        ((User) session.get(User.class, 28)).getPermissions().add(permission);
        ((User) session.get(User.class, 29)).getPermissions().add(permission);
        //user2.getPermissions().remove(permission2);
*/

        //User user3 =  (User) session.get(User.class, 26);

        //Permission permission3 =  session.get(Permission.class, 18);
        //permission3.getUsers().remove(user3);
        //session.delete(permission3);

        ///////////////

        session.getTransaction().commit();
        session.close();

        StandardServiceRegistryBuilder.destroy(serviceRegistry);

    }

}
