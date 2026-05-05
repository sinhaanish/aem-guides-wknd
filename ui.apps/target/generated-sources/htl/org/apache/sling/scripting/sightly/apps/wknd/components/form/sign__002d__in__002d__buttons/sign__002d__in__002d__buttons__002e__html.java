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
package org.apache.sling.scripting.sightly.apps.wknd.components.form.sign__002d__in__002d__buttons;

import java.io.PrintWriter;
import java.util.Collection;
import javax.script.Bindings;

import org.apache.sling.scripting.sightly.render.RenderUnit;
import org.apache.sling.scripting.sightly.render.RenderContext;

public final class sign__002d__in__002d__buttons__002e__html extends RenderUnit {

    @Override
    protected final void render(PrintWriter out,
                                Bindings bindings,
                                Bindings arguments,
                                RenderContext renderContext) {
// Main Template Body -----------------------------------------------------------------------------

Object _global_placeholdertemplate = null;
Object _dynamic_properties = bindings.get("properties");
Object _global_hascontent = null;
out.write("\n\n\n\n");
_global_placeholdertemplate = renderContext.call("use", "core/wcm/components/commons/v1/templates.html", obj());
_global_hascontent = ((((!org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "signInLabel"), "")) && (!org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "signInXfPath"), ""))) && (!org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "signOutLabel"), ""))) && (!org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "signOutXfPath"), "")));
if (renderContext.getObjectModel().toBoolean(_global_hascontent)) {
    out.write("<div class=\"wknd-sign-in-buttons\" data-current-user-url=\"/libs/granite/security/currentuser.json\">\n\n    <span class=\"wknd-sign-in-buttons__button wknd-sign-in-buttons__button--greeting\" id=\"wkndGreetingLabel\">");
    {
        Object var_0 = renderContext.call("xss", renderContext.call("i18n", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "greetingLabel"), obj().with("i18n", null)), "text");
        out.write(renderContext.getObjectModel().toString(var_0));
    }
    out.write("</span>\n\n    ");
    {
        boolean var_testvariable1 = (!org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "signInLabel"), ""));
        if (var_testvariable1) {
            out.write("<a href=\"#sign-in\" class=\"wknd-sign-in-buttons__button wknd-sign-in-buttons__button--sign-in\"");
            {
                Object var_attrvalue2 = renderContext.call("uriManipulation", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "signInXfPath"), obj().with("selectors", "content").with("extension", "html"));
                {
                    Object var_attrcontent3 = renderContext.call("xss", var_attrvalue2, "attribute");
                    {
                        boolean var_shoulddisplayattr5 = (((null != var_attrcontent3) && (!"".equals(var_attrcontent3))) && ((!"".equals(var_attrvalue2)) && (!((Object)false).equals(var_attrvalue2))));
                        if (var_shoulddisplayattr5) {
                            out.write(" data-modal-url");
                            {
                                boolean var_istrueattr4 = (var_attrvalue2.equals(true));
                                if (!var_istrueattr4) {
                                    out.write("=\"");
                                    out.write(renderContext.getObjectModel().toString(var_attrcontent3));
                                    out.write("\"");
                                }
                            }
                        }
                    }
                }
            }
            out.write(">");
            {
                Object var_6 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "signInLabel"), "text");
                out.write(renderContext.getObjectModel().toString(var_6));
            }
            out.write("</a>");
        }
    }
    out.write("\n\n    ");
    {
        boolean var_testvariable7 = (!org.apache.sling.scripting.sightly.compiler.expression.nodes.BinaryOperator.strictEq(renderContext.getObjectModel().resolveProperty(_dynamic_properties, "signOutLabel"), ""));
        if (var_testvariable7) {
            out.write("<a href=\"#sign-out\" class=\"wknd-sign-in-buttons__button wknd-sign-out-buttons__button--sign-out\"");
            {
                Object var_attrvalue8 = renderContext.call("uriManipulation", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "signOutXfPath"), obj().with("selectors", "content").with("extension", "html"));
                {
                    Object var_attrcontent9 = renderContext.call("xss", var_attrvalue8, "attribute");
                    {
                        boolean var_shoulddisplayattr11 = (((null != var_attrcontent9) && (!"".equals(var_attrcontent9))) && ((!"".equals(var_attrvalue8)) && (!((Object)false).equals(var_attrvalue8))));
                        if (var_shoulddisplayattr11) {
                            out.write(" data-modal-url");
                            {
                                boolean var_istrueattr10 = (var_attrvalue8.equals(true));
                                if (!var_istrueattr10) {
                                    out.write("=\"");
                                    out.write(renderContext.getObjectModel().toString(var_attrcontent9));
                                    out.write("\"");
                                }
                            }
                        }
                    }
                }
            }
            out.write(">");
            {
                Object var_12 = renderContext.call("xss", renderContext.getObjectModel().resolveProperty(_dynamic_properties, "signOutLabel"), "text");
                out.write(renderContext.getObjectModel().toString(var_12));
            }
            out.write("</a>");
        }
    }
    out.write("\n\n</div>");
}
out.write("\n");
{
    Object var_templatevar13 = renderContext.getObjectModel().resolveProperty(_global_placeholdertemplate, "placeholder");
    {
        boolean var_templateoptions14_field$_isempty = (!renderContext.getObjectModel().toBoolean(_global_hascontent));
        {
            java.util.Map var_templateoptions14 = obj().with("isEmpty", var_templateoptions14_field$_isempty);
            callUnit(out, renderContext, var_templatevar13, var_templateoptions14);
        }
    }
}
out.write("\n");


// End Of Main Template Body ----------------------------------------------------------------------
    }



    {
//Sub-Templates Initialization --------------------------------------------------------------------



//End of Sub-Templates Initialization -------------------------------------------------------------
    }

}

