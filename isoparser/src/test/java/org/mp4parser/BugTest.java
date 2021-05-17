/*
 * Licensed under the Apache License, Version 2.0 (the License);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an AS IS BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.mp4parser;

import org.junit.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class BugTest {

    @Test
    public void testInfiniteLoop() throws Exception {
        try (IsoFile file = new IsoFile(getBugFile("testMP4_truncated.m4a-1-5-142"))) {
            file.getMovieBox();
        }
    }

    @Test
    public void testZeroSizeRecord() throws Exception {
        File file = getBugFile("TIKA-3405.mov");
        try (IsoFile isoFile = new IsoFile(file)) {
           assertEquals(file.length(), isoFile.getSize());
        }
    }


    private File getBugFile(String fileName) {
        try {
            return Paths.get(this.getClass().getResource("/bugs/"+fileName).toURI()).toFile();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
