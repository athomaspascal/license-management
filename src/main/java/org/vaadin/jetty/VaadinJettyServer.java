package org.vaadin.jetty;

import com.vaadin.server.DefaultUIProvider;
import com.vaadin.server.UIProvider;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VaadinJettyServer extends Server {
    private static final String DEFAULT_WEBAPP_DIRECTORY = "target/classes";
    private static final String DEFAULT_CONTEXT_PATH = "/";

    public VaadinJettyServer(InetSocketAddress adress, Class<? extends UI> uiClass) throws IOException {
        this(adress, uiClass, DefaultUIProvider.class, "target/classes", "/");
    }

    public VaadinJettyServer(int port, Class<? extends UI> uiClass) throws IOException {
        this(port, uiClass, DefaultUIProvider.class, "target/classes", "/");
    }

    public VaadinJettyServer(int port, Class<? extends UI> uiClass, Class<? extends UIProvider> uiProvider) throws IOException {
        this(port, uiClass, uiProvider, "target/classes", "/");
    }

    public VaadinJettyServer(int port, Class<? extends UI> uiClass, String webappDirectory) throws IOException {
        this(port, uiClass, DefaultUIProvider.class, webappDirectory, "/");
    }

    public VaadinJettyServer(int port, Class<? extends UI> uiClass, String webappDirectory, String contextPath) throws IOException {
        this(port, uiClass, DefaultUIProvider.class, webappDirectory, contextPath);
    }


    public VaadinJettyServer(int port, Class<? extends UI> uiClass, Class<? extends UIProvider> uiProvider, String webappDirectory, String contextPath) throws IOException {
        super(port);
        ServletHolder servlet = this.buildVaadinServlet(uiClass, uiProvider);
        this.createIfDoesntExists(webappDirectory);
        WebAppContext context = new WebAppContext(webappDirectory, contextPath);
        context.addServlet(servlet, "/*");
        this.setHandler(context);
    }

    public VaadinJettyServer(InetSocketAddress address, Class<? extends UI> uiClass, Class<? extends UIProvider> uiProvider, String webappDirectory, String contextPath) throws IOException {
        super(address);
        ServletHolder servlet = this.buildVaadinServlet(uiClass, uiProvider);
        this.createIfDoesntExists(webappDirectory);
        WebAppContext context = new WebAppContext(webappDirectory, contextPath);
        context.addServlet(servlet, "/*");
        this.setHandler(context);
    }

    private ServletHolder buildVaadinServlet(Class<? extends UI> uiClass, Class<? extends UIProvider> uiProvider) {
        ServletHolder servlet = new ServletHolder(new VaadinServlet());
        servlet.setInitParameter("UIProvider", uiProvider.getName());
        servlet.setInitParameter("UI", uiClass.getName());
        return servlet;
    }

    private void createIfDoesntExists(String directory) throws IOException {
        Path path = Paths.get(directory);
        if (!Files.exists(path, new LinkOption[0])) {
            Files.createDirectory(path);
        }

    }
}
