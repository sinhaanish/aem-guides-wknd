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

public final class customheaderlibs__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

out.write("\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\"/>\n\n\n<link rel=\"preconnect\" href=\"https://fonts.googleapis.com\"/>\n<link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin/>\n<link href=\"https://fonts.googleapis.com/css2?family=Asar&family=Source+Sans+Pro:ital,wght@0,300;0,400;0,600;1,300;1,400;1,600&display=swap\" rel=\"stylesheet\"/>\n\n\n");
{
    Object var_resourcecontent0 = renderContext.call("includeResource", "contexthub", obj().with("resourceType", "granite/contexthub/components/contexthub"));
    out.write(renderContext.getObjectModel().toString(var_resourcecontent0));
}
out.write("\n\n\n<meta name=\"theme-color\" content=\"#FFEA00\"/>\n<link rel=\"manifest\" href=\"/etc.clientlibs/wknd/clientlibs/clientlib-site/resources/manifest.json\"/>\n\n\n");
{
    Object var_includedresult1 = renderContext.call("include", "favicons.html", obj());
    out.write(renderContext.getObjectModel().toString(var_includedresult1));
}
out.write("\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

