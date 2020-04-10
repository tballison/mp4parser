package org.mp4parser;

import org.junit.Test;
import org.mp4parser.boxes.iso14496.part12.MovieBox;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class BugTest {

    @Test
    public void testInfiniteLoop() throws Exception {
        IsoFile file = new IsoFile(getBugFile("testMP4_truncated.m4a-1-5-142"));
    }

    @Test
    public void testInfiniteLoop() throws Exception {
        //IsoFile file = new IsoFile(getBugFile("testMP4_truncated.m4a-1-5-142"));
        //file.getMovieBox();
    }

    private File getBugFile(String fileName) {
        try {
            return Paths.get(this.getClass().getResource("/bugs/"+fileName).toURI()).toFile();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
