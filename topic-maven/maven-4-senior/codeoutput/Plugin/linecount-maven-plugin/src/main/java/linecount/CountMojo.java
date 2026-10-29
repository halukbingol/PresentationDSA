package linecount;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/** Counts the lines of the Java sources; fails the build above a limit. */
@Mojo(name = "count", defaultPhase = LifecyclePhase.VERIFY, threadSafe = true)
public class CountMojo extends AbstractMojo {
    @Parameter(defaultValue = "${project.build.sourceDirectory}", readonly = true)
    private File sources;

    @Parameter(property = "linecount.max", defaultValue = "1000")
    private int max;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        long lines = 0;
        try (Stream<Path> files = Files.walk(sources.toPath())) {
            List<Path> java = files.filter(p -> p.toString().endsWith(".java")).toList();
            for (Path p : java) {
                lines += Files.readAllLines(p).size();
            }
            getLog().info(java.size() + " files, " + lines + " lines (max " + max + ")");
        } catch (IOException e) {
            throw new MojoExecutionException("cannot read " + sources, e);
        }
        if (lines > max) {
            throw new MojoFailureException("too many lines: " + lines + " > " + max);
        }
    }
}
