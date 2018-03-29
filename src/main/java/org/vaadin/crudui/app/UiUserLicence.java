package org.vaadin.crudui.app;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import org.vaadin.crudui.crud.Crud;
import org.vaadin.crudui.crud.CrudListener;
import org.vaadin.crudui.crud.CrudOperation;
import org.vaadin.crudui.crud.impl.GridCrud;
import org.vaadin.crudui.entity.UserLicence;
import org.vaadin.crudui.form.impl.form.factory.GridLayoutCrudFormFactory;
import org.vaadin.jetty.VaadinJettyServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.Properties;

/**
 * @author Alejandro Duarte
 */
public class UiUserLicence extends UI implements CrudListener<UserLicence> {

    public static void main(String[] args) {


        JpaUserLicence.init();
        Properties p = new Properties();
        try {
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("start.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int port = Integer.parseInt(p.getProperty("port"));
        String host = p.getProperty("host");
        InetSocketAddress byAddress1 = new InetSocketAddress(host, port);

        VaadinJettyServer server = null;
        try {
            server = new VaadinJettyServer(byAddress1, UiUserLicence.class);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private TabSheet tabSheet = new TabSheet();
    public Label title;

    @Override
    protected void init(VaadinRequest request) {
        //tabSheet.setSizeFull();
        title = new Label("Licence Management");
        title.setStyleName("h1");
        CssLayout h1 = new CssLayout();
        //tabSheet.setSizeUndefined();
        h1.addComponents(title,tabSheet);

        //h1.setExpandRatio(tabSheet,0.5f);
        h1.setSizeFull();
        setContent(h1);

        addCrud(getATSCrud("etudebale2"), "etudebale2");
        addCrud(getATSCrud("cpr"), "cpr");
        addCrud(getATSCrud("etudes"), "etudes");

        //tabSheet.setSizeUndefined();
        //tabSheet.set

        /*addCrud(getUserLicenceCrud(), "Default");*/

        /*
        addCrud(getDefaultCrudWithFixes(), "Default (with fixes)");
        addCrud(getConfiguredCrud(), "Configured");
        addCrud(getEditableGridCrud(), "Editable Grid");*/
    }

    private void addCrud(Crud crud, String caption) {
        VerticalLayout layout = new VerticalLayout(crud);
        //layout.setSizeFull();
        //layout.setExpandRatio(crud,0.5f);
        layout.setMargin(true);

        tabSheet.addTab(layout, caption);
    }
/*
    private Crud getUserLicenceCrud() {
        return new GridCrud<>(UserLicence.class, this);
    }
*/
    private Crud getATSCrud(String filtre) {
        GridCrud<UserLicence> crud = new GridCrud<>(UserLicence.class, this);
        crud.setFiltre(filtre);
        setCrudProperties(crud);

        return crud;
    }




    private void setCrudProperties(GridCrud<UserLicence> crud) {
        crud.getGrid().setColumns("idUser","userName","desktopNumber","userNumber",
                "userEmail","licenseStart","licenseStop","teamLeader","secondTeamLeader","team",
                "requestOpenNumber","requestCloseNumber","userConnection","homeDirectory");

        GridLayoutCrudFormFactory<UserLicence> formFactory = new GridLayoutCrudFormFactory<>(UserLicence.class, 2, 2);
        formFactory.setVisibleProperties(CrudOperation.UPDATE, "userName","desktopNumber","userNumber",
                "userEmail","licenseStart","licenseStop","teamLeader","secondTeamLeader","team",
                "requestOpenNumber","requestCloseNumber","userConnection","homeDirectory");
        formFactory.setVisibleProperties(CrudOperation.ADD,"userName","desktopNumber","userNumber",
                "userEmail","licenseStart","licenseStop","teamLeader","secondTeamLeader","team",
                "requestOpenNumber","requestCloseNumber","userConnection","homeDirectory");
        crud.setCrudFormFactory(formFactory);
        formFactory.setButtonCaption(CrudOperation.ADD, "Add new userLicence");

        formFactory.setUseBeanValidation(true);
    }

    @Override
    public UserLicence add(UserLicence userLicence) {
        VerticalLayout c = (VerticalLayout) tabSheet.getSelectedTab();
        GridCrud<UserLicence> g = (GridCrud<UserLicence>) c.getComponent(0);
        userLicence.setTeam(g.getFiltre());
        UserLicenceRepository.save(userLicence);
        return userLicence;
    }

    @Override
    public UserLicence update(UserLicence userLicence) {
        VerticalLayout c = (VerticalLayout) tabSheet.getSelectedTab();
        GridCrud<UserLicence> g = (GridCrud<UserLicence>) c.getComponent(0);
        userLicence.setTeam(g.getFiltre());

        return UserLicenceRepository.save(userLicence);
    }


    @Override
    public UserLicence detail(UserLicence userLicence) {
        VerticalLayout c = (VerticalLayout) tabSheet.getSelectedTab();
        GridCrud<UserLicence> g = (GridCrud<UserLicence>) c.getComponent(0);
        userLicence.setTeam(g.getFiltre());

        return UserLicenceRepository.save(userLicence);
    }

    @Override
    public void delete(UserLicence userLicence) {
        UserLicenceRepository.delete(userLicence);
    }

    @Override
    public Collection<UserLicence> findAll() {
        return UserLicenceRepository.findAll();
    }

    @Override
    public Collection<UserLicence> findAllFilter(String filtre) {
        return UserLicenceRepository.findAllFilter(filtre);
    }


}
