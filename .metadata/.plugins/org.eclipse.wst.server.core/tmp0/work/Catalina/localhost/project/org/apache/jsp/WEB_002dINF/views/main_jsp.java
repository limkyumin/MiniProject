/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.78
 * Generated at: 2023-01-02 06:41:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1672382798122L));
    _jspx_dependants.put("jar:file:/C:/202212PJ/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/MiniProject/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<meta content=\"\" name=\"description\">\r\n");
      out.write("  <meta content=\"\" name=\"keywords\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Favicons -->\r\n");
      out.write("  <link href=\"./resources/img/favicon.png\" rel=\"icon\">\r\n");
      out.write("  <link href=\"./resources/img/apple-touch-icon.png\" rel=\"apple-touch-icon\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Google Fonts -->\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Vendor CSS Files -->\r\n");
      out.write("  <link href=\"./resources/vendor/animate.css/animate.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  <link href=\"./resources/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  <link href=\"./resources/vendor/bootstrap-icons/bootstrap-icons.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  <link href=\"./resources/vendor/boxicons/css/boxicons.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  <link href=\"./resources/vendor/glightbox/css/glightbox.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("  <link href=\"./resources/vendor/swiper/swiper-bundle.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Template Main CSS File -->\r\n");
      out.write("  <link href=\"./resources/css/style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/header.jsp", out, false);
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <!-- ======= Hero Section ======= -->\r\n");
      out.write("  <section id=\"hero\">\r\n");
      out.write("    <div class=\"hero-container\">\r\n");
      out.write("      <div id=\"heroCarousel\" data-bs-interval=\"5000\" class=\"carousel slide carousel-fade\" data-bs-ride=\"carousel\">\r\n");
      out.write("\r\n");
      out.write("        <ol class=\"carousel-indicators\" id=\"hero-carousel-indicators\"></ol>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"carousel-inner\" role=\"listbox\">\r\n");
      out.write("\r\n");
      out.write("          <!-- Slide 1 -->\r\n");
      out.write("          <div class=\"carousel-item active\" style=\"background-image: url(./resources/img/slide/slide-1.jpg);\">\r\n");
      out.write("            <div class=\"carousel-container\">\r\n");
      out.write("              <div class=\"carousel-content\">\r\n");
      out.write("                <h2 class=\"animate__animated animate__fadeInDown\">?????? ??????????????? ?????????????????? ???????????????</h2>\r\n");
      out.write("                <p class=\"animate__animated animate__fadeInUp\">???????????? ??????</p>\r\n");
      out.write("                <div>\r\n");
      out.write("                  <a href=\"noticeMain.ui\" class=\"btn-get-started animate__animated animate__fadeInUp scrollto\">READ NOTICE</a>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <!-- Slide 2 -->\r\n");
      out.write("          <div class=\"carousel-item\" style=\"background-image: url(./resources/img/slide/slide-2.jpg);\">\r\n");
      out.write("            <div class=\"carousel-container\">\r\n");
      out.write("              <div class=\"carousel-content\">\r\n");
      out.write("                <h2 class=\"animate__animated animate__fadeInDown\">???????????? SHOP</h2>\r\n");
      out.write("                <p class=\"animate__animated animate__fadeInUp\">????????? ??????????????? ???????????????.</p>\r\n");
      out.write("                <div>\r\n");
      out.write("                  <a href=\"productMain.ui\" class=\"btn-get-started animate__animated animate__fadeInUp scrollto\">READ SHOP</a>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <!-- Slide 3 -->\r\n");
      out.write("          <div class=\"carousel-item\" style=\"background-image: url(./resources/img/slide/slide-3.jpg);\">\r\n");
      out.write("            <div class=\"carousel-container\">\r\n");
      out.write("              <div class=\"carousel-content\">\r\n");
      out.write("                <h2 class=\"animate__animated animate__fadeInDown\">Sequi ea ut et est quaerat</h2>\r\n");
      out.write("                <p class=\"animate__animated animate__fadeInUp\">Ut velit est quam dolor ad a aliquid qui aliquid. Sequi ea ut et est quaerat sequi nihil ut aliquam. Occaecati alias dolorem mollitia ut. Similique ea voluptatem. Esse doloremque accusamus repellendus deleniti vel. Minus et tempore modi architecto.</p>\r\n");
      out.write("                <div>\r\n");
      out.write("                  <a href=\"#about\" class=\"btn-get-started animate__animated animate__fadeInUp scrollto\">Read More</a>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <a class=\"carousel-control-prev\" href=\"#heroCarousel\" role=\"button\" data-bs-slide=\"prev\">\r\n");
      out.write("          <span class=\"carousel-control-prev-icon bi bi-chevron-left\" aria-hidden=\"true\"></span>\r\n");
      out.write("        </a>\r\n");
      out.write("\r\n");
      out.write("        <a class=\"carousel-control-next\" href=\"#heroCarousel\" role=\"button\" data-bs-slide=\"next\">\r\n");
      out.write("          <span class=\"carousel-control-next-icon bi bi-chevron-right\" aria-hidden=\"true\"></span>\r\n");
      out.write("        </a>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </section><!-- End Hero -->\r\n");
      out.write("\r\n");
      out.write("  <main id=\"main\">\r\n");
      out.write("\r\n");
      out.write("    <!-- ======= About Section ======= -->\r\n");
      out.write("    <section id=\"about\" class=\"about\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row no-gutters\">\r\n");
      out.write("          <div class=\"image col-xl-5 d-flex align-items-stretch justify-content-center justify-content-lg-start\"></div>\r\n");
      out.write("          <div class=\"col-xl-7 ps-0 ps-lg-5 pe-lg-1 d-flex align-items-stretch\">\r\n");
      out.write("            <div class=\"content d-flex flex-column justify-content-center\">\r\n");
      out.write("              <h3>Voluptatem dignissimos provident quasi</h3>\r\n");
      out.write("              <p>\r\n");
      out.write("                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Duis aute irure dolor in reprehenderit\r\n");
      out.write("              </p>\r\n");
      out.write("              <div class=\"row\">\r\n");
      out.write("                <div class=\"col-md-6 icon-box\">\r\n");
      out.write("                  <i class=\"bx bx-receipt\"></i>\r\n");
      out.write("                  <h4>Corporis voluptates sit</h4>\r\n");
      out.write("                  <p>Consequuntur sunt aut quasi enim aliquam quae harum pariatur laboris nisi ut aliquip</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6 icon-box\">\r\n");
      out.write("                  <i class=\"bx bx-cube-alt\"></i>\r\n");
      out.write("                  <h4>Ullamco laboris nisi</h4>\r\n");
      out.write("                  <p>Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6 icon-box\">\r\n");
      out.write("                  <i class=\"bx bx-images\"></i>\r\n");
      out.write("                  <h4>Labore consequatur</h4>\r\n");
      out.write("                  <p>Aut suscipit aut cum nemo deleniti aut omnis. Doloribus ut maiores omnis facere</p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-6 icon-box\">\r\n");
      out.write("                  <i class=\"bx bx-shield\"></i>\r\n");
      out.write("                  <h4>Beatae veritatis</h4>\r\n");
      out.write("                  <p>Expedita veritatis consequuntur nihil tempore laudantium vitae denat pacta</p>\r\n");
      out.write("                </div>\r\n");
      out.write("              </div>\r\n");
      out.write("            </div><!-- End .content-->\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </section><!-- End About Section -->\r\n");
      out.write("\r\n");
      out.write("    <!-- ======= Counts Section ======= -->\r\n");
      out.write("    <section id=\"counts\" class=\"counts\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row no-gutters\">\r\n");
      out.write("\r\n");
      out.write("          <div class=\"col-lg-3 col-md-6 d-md-flex align-items-md-stretch\">\r\n");
      out.write("            <div class=\"count-box\">\r\n");
      out.write("              <i class=\"bi bi-emoji-smile\"></i>\r\n");
      out.write("              <span data-purecounter-start=\"0\" data-purecounter-end=\"232\" data-purecounter-duration=\"1\" class=\"purecounter\"></span>\r\n");
      out.write("              <p><strong>Happy Clients</strong> consequuntur quae</p>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <div class=\"col-lg-3 col-md-6 d-md-flex align-items-md-stretch\">\r\n");
      out.write("            <div class=\"count-box\">\r\n");
      out.write("              <i class=\"bi bi-journal-richtext\"></i>\r\n");
      out.write("              <span data-purecounter-start=\"0\" data-purecounter-end=\"521\" data-purecounter-duration=\"1\" class=\"purecounter\"></span>\r\n");
      out.write("              <p><strong>Projects</strong> adipisci atque cum quia aut</p>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <div class=\"col-lg-3 col-md-6 d-md-flex align-items-md-stretch\">\r\n");
      out.write("            <div class=\"count-box\">\r\n");
      out.write("              <i class=\"bi bi-headset\"></i>\r\n");
      out.write("              <span data-purecounter-start=\"0\" data-purecounter-end=\"1463\" data-purecounter-duration=\"1\" class=\"purecounter\"></span>\r\n");
      out.write("              <p><strong>Hours Of Support</strong> aut commodi quaerat</p>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <div class=\"col-lg-3 col-md-6 d-md-flex align-items-md-stretch\">\r\n");
      out.write("            <div class=\"count-box\">\r\n");
      out.write("              <i class=\"bi bi-people\"></i>\r\n");
      out.write("              <span data-purecounter-start=\"0\" data-purecounter-end=\"15\" data-purecounter-duration=\"1\" class=\"purecounter\"></span>\r\n");
      out.write("              <p><strong>Hard Workers</strong> rerum asperiores dolor</p>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </section><!-- End Counts Section -->\r\n");
      out.write("\r\n");
      out.write("    <!-- ======= Clients Section ======= -->\r\n");
      out.write("    <section id=\"clients\" class=\"clients section-bg\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("\r\n");
      out.write("          <div class=\"col-lg-2 col-md-4 col-6 d-flex align-items-center justify-content-center\">\r\n");
      out.write("            <img src=\"./resources/img/clients/client-1.png\" class=\"img-fluid\" alt=\"\">\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <div class=\"col-lg-2 col-md-4 col-6 d-flex align-items-center justify-content-center\">\r\n");
      out.write("            <img src=\"./resources/img/clients/client-2.png\" class=\"img-fluid\" alt=\"\">\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <div class=\"col-lg-2 col-md-4 col-6 d-flex align-items-center justify-content-center\">\r\n");
      out.write("            <img src=\"./resources/img/clients/client-3.png\" class=\"img-fluid\" alt=\"\">\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <div class=\"col-lg-2 col-md-4 col-6 d-flex align-items-center justify-content-center\">\r\n");
      out.write("            <img src=\"./resources/img/clients/client-4.png\" class=\"img-fluid\" alt=\"\">\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <div class=\"col-lg-2 col-md-4 col-6 d-flex align-items-center justify-content-center\">\r\n");
      out.write("            <img src=\"./resources/img/clients/client-5.png\" class=\"img-fluid\" alt=\"\">\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("          <div class=\"col-lg-2 col-md-4 col-6 d-flex align-items-center justify-content-center\">\r\n");
      out.write("            <img src=\"./resources/img/clients/client-6.png\" class=\"img-fluid\" alt=\"\">\r\n");
      out.write("          </div>\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </section><!-- End Clients Section -->\r\n");
      out.write("\r\n");
      out.write("    <!-- ======= Services Section ======= -->\r\n");
      out.write("    <section id=\"services\" class=\"services\">\r\n");
      out.write("      <div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"section-title\">\r\n");
      out.write("          <h2>Services</h2>\r\n");
      out.write("          <p>Magnam dolores commodi suscipit. Necessitatibus eius consequatur ex aliquid fuga eum quidem. Sit sint consectetur velit. Quisquam quos quisquam cupiditate. Et nemo qui impedit suscipit alias ea. Quia fugiat sit in iste officiis commodi quidem hic quas.</p>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div class=\"row\">\r\n");
      out.write("          <div class=\"col-lg-4 col-md-6 icon-box\">\r\n");
      out.write("            <div class=\"icon\"><i class=\"bi bi-briefcase\"></i></div>\r\n");
      out.write("            <h4 class=\"title\"><a href=\"\">Lorem Ipsum</a></h4>\r\n");
      out.write("            <p class=\"description\">Voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident</p>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-lg-4 col-md-6 icon-box\">\r\n");
      out.write("            <div class=\"icon\"><i class=\"bi bi-card-checklist\"></i></div>\r\n");
      out.write("            <h4 class=\"title\"><a href=\"\">Dolor Sitema</a></h4>\r\n");
      out.write("            <p class=\"description\">Minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat tarad limino ata</p>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-lg-4 col-md-6 icon-box\">\r\n");
      out.write("            <div class=\"icon\"><i class=\"bi bi-bar-chart\"></i></div>\r\n");
      out.write("            <h4 class=\"title\"><a href=\"\">Sed ut perspiciatis</a></h4>\r\n");
      out.write("            <p class=\"description\">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur</p>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-lg-4 col-md-6 icon-box\">\r\n");
      out.write("            <div class=\"icon\"><i class=\"bi bi-binoculars\"></i></div>\r\n");
      out.write("            <h4 class=\"title\"><a href=\"\">Magni Dolores</a></h4>\r\n");
      out.write("            <p class=\"description\">Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-lg-4 col-md-6 icon-box\">\r\n");
      out.write("            <div class=\"icon\"><i class=\"bi bi-brightness-high\"></i></div>\r\n");
      out.write("            <h4 class=\"title\"><a href=\"\">Nemo Enim</a></h4>\r\n");
      out.write("            <p class=\"description\">At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque</p>\r\n");
      out.write("          </div>\r\n");
      out.write("          <div class=\"col-lg-4 col-md-6 icon-box\">\r\n");
      out.write("            <div class=\"icon\"><i class=\"bi bi-calendar4-week\"></i></div>\r\n");
      out.write("            <h4 class=\"title\"><a href=\"\">Eiusmod Tempor</a></h4>\r\n");
      out.write("            <p class=\"description\">Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi</p>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </section><!-- End Services Section -->\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"copyright\">\r\n");
      out.write("        &copy; Copyright <strong><span>Groovin</span></strong>. All Rights Reserved\r\n");
      out.write("      </div>\r\n");
      out.write("      <div class=\"credits\">\r\n");
      out.write("        <!-- All the links in the footer should remain intact. -->\r\n");
      out.write("        <!-- You can delete the links only if you purchased the pro version. -->\r\n");
      out.write("        <!-- Licensing information: https://bootstrapmade.com/license/ -->\r\n");
      out.write("        <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/groovin-free-bootstrap-theme/ -->\r\n");
      out.write("        Designed by <a href=\"https://bootstrapmade.com/\">BootstrapMade</a>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </footer><!-- End Footer -->\r\n");
      out.write("\r\n");
      out.write("  <a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>\r\n");
      out.write("\r\n");
      out.write("  <!-- Vendor JS Files -->\r\n");
      out.write("  <script src=\"./resources/vendor/purecounter/purecounter_vanilla.js\"></script>\r\n");
      out.write("  <script src=\"./resources/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("  <script src=\"./resources/vendor/glightbox/js/glightbox.min.js\"></script>\r\n");
      out.write("  <script src=\"./resources/vendor/isotope-layout/isotope.pkgd.min.js\"></script>\r\n");
      out.write("  <script src=\"./resources/vendor/swiper/swiper-bundle.min.js\"></script>\r\n");
      out.write("  <script src=\"./resources/vendor/php-email-form/validate.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <!-- Template Main JS File -->\r\n");
      out.write("  <script src=\"./resources/js/main.js\"></script>\r\n");
      out.write("	\r\n");
      out.write("<!-- 		<script>\r\n");
      out.write("	$(function(){\r\n");
      out.write("		$(\"tbody\").on(\"click, \"tr\", function(){\r\n");
      out.write("			location.href=\"detail.bo?bno\" + $(this).children().eq(0).text();\r\n");
      out.write("		});\r\n");
      out.write("	});\r\n");
      out.write("	</script>\r\n");
      out.write(" -->	\r\n");
      out.write("	\r\n");
      out.write("	<script>\r\n");
      out.write("		\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
