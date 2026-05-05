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
package org.apache.sling.scripting.sightly.apps.wknd.components.languagenavigation;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class itemContent__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _dynamic_itemcontent = getProperty("itemcontent");
out.write("\n  ");
out.write("\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------

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
addSubTemplate("itemContent", new RenderUnit() {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Sub-Template Body -------------------------------------------------------------------------

Object _dynamic_item = arguments.get("item");
Object _global_haschildren = null;
out.write("\n    ");
_global_haschildren = (!(org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.leq(renderContext.getObjectModel().resolveProperty(renderContext.getObjectModel().resolveProperty(_dynamic_item, "children"), "size"), 0)));
if (renderContext.getObjectModel().toBoolean(_global_haschildren)) {
    out.write("<span class=\"cmp-languagenavigation__item-title\"");
    {
        Object var_attrvalue0 = renderContext.getObjectModel().resolveProperty(_dynamic_item, "language");
        {
            Object var_attrcontent1 = renderContext.call("xss", var_attrvalue0, "attribute");
            {
                boolean var_shoulddisplayattr3 = (((null != var_attrcontent1) && (!"".equals(var_attrcontent1))) && ((!"".equals(var_attrvalue0)) && (!((Object)false).equals(var_attrvalue0))));
                if (var_shoulddisplayattr3) {
                    out.write(" lang");
                    {
                        boolean var_istrueattr2 = (var_attrvalue0.equals(true));
                        if (!var_istrueattr2) {
                            out.write("=\"");
                            out.write(renderContext.getObjectModel().toString(var_attrcontent1));
                            out.write("\"");
                        }
                    }
                }
            }
        }
    }
    out.write(">");
    {
        Object var_4 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_item, "title"), "text");
        out.write(renderContext.getObjectModel().toString(var_4));
    }
    out.write("</span>");
}
out.write("\n    ");
{
    boolean var_testvariable5 = (!renderContext.getObjectModel().toBoolean(_global_haschildren));
    if (var_testvariable5) {
        out.write("<a class=\"cmp-languagenavigation__item-link\"");
        {
            Object var_attrvalue6 = renderContext.getObjectModel().resolveProperty(_dynamic_item, "URL");
            {
                Object var_attrcontent7 = renderContext.call("xss", var_attrvalue6, "uri");
                {
                    boolean var_shoulddisplayattr9 = (((null != var_attrcontent7) && (!"".equals(var_attrcontent7))) && ((!"".equals(var_attrvalue6)) && (!((Object)false).equals(var_attrvalue6))));
                    if (var_shoulddisplayattr9) {
                        out.write(" href");
                        {
                            boolean var_istrueattr8 = (var_attrvalue6.equals(true));
                            if (!var_istrueattr8) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent7));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        {
            Object var_attrvalue10 = renderContext.getObjectModel().resolveProperty(_dynamic_item, "language");
            {
                Object var_attrcontent11 = renderContext.call("xss", var_attrvalue10, "attribute");
                {
                    boolean var_shoulddisplayattr13 = (((null != var_attrcontent11) && (!"".equals(var_attrcontent11))) && ((!"".equals(var_attrvalue10)) && (!((Object)false).equals(var_attrvalue10))));
                    if (var_shoulddisplayattr13) {
                        out.write(" hreflang");
                        {
                            boolean var_istrueattr12 = (var_attrvalue10.equals(true));
                            if (!var_istrueattr12) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent11));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        {
            Object var_attrvalue14 = renderContext.getObjectModel().resolveProperty(_dynamic_item, "language");
            {
                Object var_attrcontent15 = renderContext.call("xss", var_attrvalue14, "attribute");
                {
                    boolean var_shoulddisplayattr17 = (((null != var_attrcontent15) && (!"".equals(var_attrcontent15))) && ((!"".equals(var_attrvalue14)) && (!((Object)false).equals(var_attrvalue14))));
                    if (var_shoulddisplayattr17) {
                        out.write(" lang");
                        {
                            boolean var_istrueattr16 = (var_attrvalue14.equals(true));
                            if (!var_istrueattr16) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent15));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write(" rel=\"alternate\"");
        {
            Object var_attrvalue18 = renderContext.getObjectModel().resolveProperty(_dynamic_item, "title");
            {
                Object var_attrcontent19 = renderContext.call("xss", var_attrvalue18, "attribute");
                {
                    boolean var_shoulddisplayattr21 = (((null != var_attrcontent19) && (!"".equals(var_attrcontent19))) && ((!"".equals(var_attrvalue18)) && (!((Object)false).equals(var_attrvalue18))));
                    if (var_shoulddisplayattr21) {
                        out.write(" title");
                        {
                            boolean var_istrueattr20 = (var_attrvalue18.equals(true));
                            if (!var_istrueattr20) {
                                out.write("=\"");
                                out.write(renderContext.getObjectModel().toString(var_attrcontent19));
                                out.write("\"");
                            }
                        }
                    }
                }
            }
        }
        out.write(">");
        {
            Object var_22 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_item, "language"), "text");
            out.write(renderContext.getObjectModel().toString(var_22));
        }
        out.write("</a>");
    }
}
out.write("\n");


// End Of Main Sub-Template Body ------------------------------------------------------------------
    }



    {
//Sub-Sub-Templates Initialization ----------------------------------------------------------------



//End of Sub-Sub-Templates Initialization ---------------------------------------------------------
    }
    
});


//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

