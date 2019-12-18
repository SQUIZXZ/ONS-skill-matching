package com.nsa.ons.onsgroupproject.architecture;

import com.structurizr.Workspace;
import com.structurizr.analysis.ComponentFinder;
import com.structurizr.analysis.ReferencedTypesSupportingTypesStrategy;
import com.structurizr.analysis.SourceCodeComponentFinderStrategy;
import com.structurizr.analysis.SpringComponentFinderStrategy;
import com.structurizr.api.StructurizrClient;
import com.structurizr.documentation.Format;
import com.structurizr.documentation.StructurizrDocumentationTemplate;
import com.structurizr.model.*;
import com.structurizr.view.*;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;


public class GenerateModel {


    @Test
    public void generateModel() throws Exception {


        File sourceRoot = new File("C:\\Users\\C1817717\\Documents\\New folder\\group-5-project-ons-skills\\onsgroupproject");

        Workspace workspace = new Workspace("ONS GROUP 5 CLIENT PROJECT", "Group 5 Client Project");
        Model model = workspace.getModel();
        ViewSet viewSet = workspace.getViews();

        // create the context diagram

        //create our system
        SoftwareSystem onsGroupProject = model.addSoftwareSystem("ONS Skill Share Web App", "A spring boot project to provide an internal skills sharing service to employees at the Office of National Statistics");
        //add personas
        Person user = model.addPerson("User.", "An employee of the ONS who is looking to give or get help from others.");
        //define usages
        user.uses(onsGroupProject, "Uses");
        //create external dependencies
        //NONE
//        SoftwareSystem hmrc = model.addSoftwareSystem("HMRC", "Tax Office Gift Aid Services");
//        SoftwareSystem stripe = model.addSoftwareSystem("Stripe", "Card Payment Services");
        //define external usages
//        onsGroupProject.uses(hmrc, "sends dondations", "SOAP");
//        onsGroupProject.uses(stripe, "sends payment requests", "HTTPS");
        //create the view
        SystemContextView contextView = viewSet.createSystemContextView(onsGroupProject, "context", "The System Context diagram for ONS Group 5.");
        contextView.addAllSoftwareSystems();
        contextView.addAllPeople();
        contextView.setAutomaticLayout(true);


        //create the container diagram
        Container webApplication = onsGroupProject.addContainer(
                "Spring Boot Application", "The web application", "Embedded web container.  Tomcat 7.0");
        Container relationalDatabase = onsGroupProject.addContainer(
                "Relational Database", "Stores all information related to users, skills and skill requests", "MySQL");
        user.uses(webApplication, "Uses", "HTTP");

        webApplication.uses(relationalDatabase, "Reads from and writes to", "JPA, port 3306");
        //create the view
        ContainerView containerView = viewSet.createContainerView(onsGroupProject, "containers", "The Containers diagram for the ONS system.");
        containerView.addAllContainers();
        containerView.setAutomaticLayout(true);

        SpringComponentFinderStrategy springComponentFinderStrategy = new SpringComponentFinderStrategy(new ReferencedTypesSupportingTypesStrategy(true));
        springComponentFinderStrategy.setIncludePublicTypesOnly(false);

        System.out.println("Let's scan for components");


        // and now automatically find all Spring @Controller, @Component, @Service and @Repository components
        ComponentFinder componentFinder = new ComponentFinder(
                webApplication,
                "com.nsa.ons.onsgroupproject", //change for your package structure
                springComponentFinderStrategy
                , new SourceCodeComponentFinderStrategy(new File(sourceRoot, "/src/main/java/"), 150)
        );

        try {
            componentFinder.findComponents();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Let's see what is being scanned

        System.out.println("Component List");
        System.out.println("--------------");

        for (Component c : webApplication.getComponents()) {
            System.out.println(c);
        }

        System.out.println("Relationships");
        System.out.println("--------------");

        for (Component c : webApplication.getComponents()) {
            System.out.println(c.getRelationships());
        }

        // connect the donor to all of the Spring MVC controllers
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER))
                .forEach(c -> user.uses(c, "Uses", "HTTP"));

        // connect all of the repository components to the relational database
        webApplication.getComponents().stream()
                .filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY))
                .forEach(c -> c.uses(relationalDatabase, "Reads from and writes to", "JPA"));

        //link internal components
//
//        Component cservice = webApplication.getComponentOfType("com.nsa.ons.onsgroupproject.service.CharityFinder");
//        cservice.addTags("contrib: Carl, Simon");
//
//        System.out.println("charity service = " + cservice);
//
//        Component cRepo = webApplication.getComponentOfType("com.nsa.cm6213.charity2019walk.data.JpaCharityRepository");
//
//        System.out.println("charity repo = " + cRepo);
//
//        cservice.uses(cRepo, "uses");

        //what about templates?

//        Component charityProfilePage = webApplication.addComponent("t_charity_profile_page.html", "Charity Profile Page", "Thymeleaf");
//        System.out.println(charityProfilePage);
//
//        Component charityController = webApplication.getComponentOfType("com.nsa.cm6213.charity2019walk.web.CharityProfileController");
//        System.out.println(charityController);
//
//        charityProfilePage.uses(charityController, "is fed data by");

        //what about configuration e.g. security

        Component securityConfig = webApplication.addComponent("SecurityConfiguration", "Determines the security process", "Spring Security");
        Component userDetailsService = webApplication.addComponent("MyUserDetailsService", "Provides the User authentication and authorisation data", SpringComponentFinderStrategy.SPRING_SERVICE);
        securityConfig.uses(userDetailsService, "delegates user retrieval to");

//         Create the component view and add all components (and the database for reference).

        ComponentView componentView = viewSet.createComponentView(webApplication, "components", "The Components diagram for the ONS web application.");
        componentView.addAllComponents();
        //componentView.addAllPeople(); //could show all users using controllers.
        componentView.add(relationalDatabase);
        componentView.setAutomaticLayout(true);

        // link the architecture model with the code
        for (Component component : webApplication.getComponents()) {
            for (CodeElement codeElement : component.getCode()) {
                String sourcePath = codeElement.getUrl();
                if (sourcePath != null) {
                    codeElement.setUrl(
                            "https://gitlab.cs.cf.ac.uk/c1847920/group-5-project-ons-skills/tree/master/onsgroupproject");
                }
            }
        }

        // tag and style some elements
        onsGroupProject.addTags("ONS Skill Share Web App");
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER)).forEach(c -> c.addTags("Spring MVC Controller"));
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REST_CONTROLLER)).forEach(c -> c.addTags("Spring REST Controller"));

        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_SERVICE)).forEach(c -> c.addTags("Spring Service"));
        webApplication.getComponents().stream().filter(c -> c.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY)).forEach(c -> c.addTags("Spring Repository"));
        relationalDatabase.addTags("Database");


        Styles styles = viewSet.getConfiguration().getStyles();
        styles.addElementStyle("ONS GROUP 5 CLIENT PROJECT").background("#6CB33E").color("#ffffff");
        styles.addElementStyle(Tags.PERSON).background("#519823").color("#ffffff").shape(Shape.Person);
        styles.addElementStyle(Tags.CONTAINER).background("#91D366").color("#ffffff");
        styles.addElementStyle("Database").shape(Shape.Cylinder);

        styles.addElementStyle("Spring REST Controller").background("#C0FFd4").color("#000000");

        styles.addElementStyle("Spring MVC Controller").background("#D4F3C0").color("#000000");
        styles.addElementStyle("Spring Service").background("#6CB33E").color("#000000");
        styles.addElementStyle("Spring Repository").background("#95D46C").color("#000000");

        // add some documentation
        StructurizrDocumentationTemplate template = new StructurizrDocumentationTemplate(workspace);
        template.addContextSection(onsGroupProject, Format.Markdown,
                "This is a web app we designed in order to help project leaders \n" +
                        "find people with the right skills for the job they need doing without having to know the specific skill they need\n" +
                        "\n" +
                        "![](embed:context)");

        System.out.println("Contacting Structurizr");

        System.out.println("USE YOUR OWN KEYS FOR YOUR PROJECTS.");

        StructurizrClient structurizrClient = new StructurizrClient("740d3706-99ee-46cc-885a-9ce39d5cbdf3", "9e9a3229-3acc-48a6-84cd-81f692f881ed");

        try {
            structurizrClient.putWorkspace(49130, workspace);
            System.out.println("Uploaded");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

