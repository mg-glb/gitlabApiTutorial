package gitlabApiTutorial;

import java.io.File;
import java.util.Arrays;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class Main {

  public static void main(String[] args) {
    try {
      //Create maven project
      InvocationRequest request = new DefaultInvocationRequest();
      request.setGoals(Arrays.asList("archetype:generate",//
          "-DgroupId=com.globant",//
          "-DartifactId=testProject",//
          "-Dpackaging=jar",//
          "-DarchetypeArtifactId=maven-archetype-quickstart",//
          "-DarchetypeVersion=1.1",//
          "-DinteractiveMode=false"));
      request.setBaseDirectory(new File("C:\\\\Users\\m.gigena"));
      Invoker invoker = new DefaultInvoker();
      invoker.execute(request);
      //Set clone the empty repo
      Git git  = Git.cloneRepository()
          .setURI("https://github.com/springframeworkguru/spring-core-spring-mvc.git")
          .setDirectory(new File("C:\\Users\\m.gigena\\spring-core-spring-mvc"))
          .call();
      git.close();
    } catch (IllegalStateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (GitAPIException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (MavenInvocationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
