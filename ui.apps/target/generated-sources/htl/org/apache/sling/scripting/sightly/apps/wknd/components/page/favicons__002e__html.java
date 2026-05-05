/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 ******************************************************************************/
package org.apache.sling.scripting.sightly.apps.wknd.components.page;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class favicons__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_clientlibresources = null;
out.write("\n\n\n");
_global_clientlibresources = "/etc.clientlibs/wknd/clientlibs/clientlib-site/resources";
out.write("<link rel=\"icon\" type=\"image/png\"");
{
    String var_attrcontent0 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/images/favicons/favicon-32.png");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent0));
    out.write("\"");
}
out.write("/>\n<link rel=\"icon\" type=\"image/png\"");
{
    String var_attrcontent1 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/images/favicons/favicon-32.png");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent1));
    out.write("\"");
}
out.write(" sizes=\"32x32\"/>\n<link rel=\"icon\" type=\"image/png\"");
{
    String var_attrcontent2 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/images/favicons/favicon-128.png");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent2));
    out.write("\"");
}
out.write(" sizes=\"128x128\"/>\n<link rel=\"icon\" type=\"image/png\"");
{
    String var_attrcontent3 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/images/favicons/favicon-152.png");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent3));
    out.write("\"");
}
out.write(" sizes=\"152x152\"/>\n<link rel=\"icon\" type=\"image/png\"");
{
    String var_attrcontent4 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/images/favicons/favicon-167.png");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent4));
    out.write("\"");
}
out.write(" sizes=\"167x167\"/>\n<link rel=\"icon\" type=\"image/png\"");
{
    String var_attrcontent5 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/images/favicons/favicon-180.png");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent5));
    out.write("\"");
}
out.write(" sizes=\"180x180\"/>\n<link rel=\"icon\" type=\"image/png\"");
{
    String var_attrcontent6 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/images/favicons/favicon-192.png");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent6));
    out.write("\"");
}
out.write(" sizes=\"192x192\"/>\n<link rel=\"icon\" type=\"image/png\"");
{
    String var_attrcontent7 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/images/favicons/favicon-512.png");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent7));
    out.write("\"");
}
out.write(" sizes=\"512x512\"/>\n\n\n<link rel=\"shortcut icon\" type=\"image/png\" sizes=\"192x192\"");
{
    String var_attrcontent8 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/images/favicons/favicon-192.png");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent8));
    out.write("\"");
}
out.write("/>\n\n\n<link rel=\"apple-touch-icon\" type=\"image/png\"");
{
    String var_attrcontent9 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/images/favicons/favicon-128.png");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent9));
    out.write("\"");
}
out.write(" sizes=\"128x128\"/>\n<link rel=\"apple-touch-icon\" type=\"image/png\"");
{
    String var_attrcontent10 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/images/favicons/favicon-152.png");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent10));
    out.write("\"");
}
out.write(" sizes=\"152x152\"/>\n<link rel=\"apple-touch-icon\" type=\"image/png\"");
{
    String var_attrcontent11 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/images/favicons/favicon-167.png");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent11));
    out.write("\"");
}
out.write(" sizes=\"167x167\"/>\n<link rel=\"apple-touch-icon\" type=\"image/png\"");
{
    String var_attrcontent12 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/images/favicons/favicon-180.png");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent12));
    out.write("\"");
}
out.write(" sizes=\"180x180\"/>\n\n\n<meta name=\"msapplication-TileColor\" content=\"#FFFFFF\"/>\n<meta name=\"msapplication-TileImage\"");
{
    String var_attrcontent13 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "attribute")) + "/images/favicons/favicon-152.png");
    out.write(" content=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent13));
    out.write("\"");
}
out.write("/>\n\n\n<link rel=\"preload\"");
{
    String var_attrcontent14 = (renderContext.getObjectModel().toString(renderContext.call("xss", _global_clientlibresources, "uri")) + "/fonts/wknd-icon-font.ttf");
    out.write(" href=\"");
    out.write(renderContext.getObjectModel().toString(var_attrcontent14));
    out.write("\"");
}
out.write(" as=\"font\" type=\"font/ttf\" crossorigin/>");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

