package com.galtinnov.library.views;

import com.galtinnov.library.views.addressform.AddressFormView;
import com.galtinnov.library.views.chat.ChatView;
import com.galtinnov.library.views.checkoutform.CheckoutFormView;
import com.galtinnov.library.views.collaborativemasterdetail.CollaborativeMasterDetailView;
import com.galtinnov.library.views.creditcardform.CreditCardFormView;
import com.galtinnov.library.views.dashboard.DashboardView;
import com.galtinnov.library.views.datagrid.DataGridView;
import com.galtinnov.library.views.empty.EmptyView;
import com.galtinnov.library.views.feed.FeedView;
import com.galtinnov.library.views.gridwithfilters.GridwithFiltersView;
import com.galtinnov.library.views.helloworld.HelloWorldView;
import com.galtinnov.library.views.imagegallery.ImageGalleryView;
import com.galtinnov.library.views.masterdetail.MasterDetailView;
import com.galtinnov.library.views.myview.MyViewView;
import com.galtinnov.library.views.pageeditor.PageEditorView;
import com.galtinnov.library.views.personform.PersonFormView;
import com.galtinnov.library.views.spreadsheet.SpreadsheetView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.vaadin.lineawesome.LineAwesomeIcon;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H1 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.setAriaLabel("Menu toggle");

        viewTitle = new H1();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
    }

    private void addDrawerContent() {
        Span appName = new Span("library");
        appName.addClassNames(LumoUtility.FontWeight.SEMIBOLD, LumoUtility.FontSize.LARGE);
        Header header = new Header(appName);

        Scroller scroller = new Scroller(createNavigation());

        addToDrawer(header, scroller, createFooter());
    }

    private SideNav createNavigation() {
        SideNav nav = new SideNav();

        nav.addItem(new SideNavItem("My View", MyViewView.class, LineAwesomeIcon.PENCIL_RULER_SOLID.create()));
        nav.addItem(new SideNavItem("Empty", EmptyView.class, LineAwesomeIcon.FILE.create()));
        nav.addItem(new SideNavItem("Hello World", HelloWorldView.class, LineAwesomeIcon.GLOBE_SOLID.create()));
        nav.addItem(new SideNavItem("Dashboard", DashboardView.class, LineAwesomeIcon.CHART_AREA_SOLID.create()));
        nav.addItem(new SideNavItem("Feed", FeedView.class, LineAwesomeIcon.LIST_SOLID.create()));
        nav.addItem(new SideNavItem("Data Grid", DataGridView.class, LineAwesomeIcon.TH_SOLID.create()));
        nav.addItem(new SideNavItem("Master-Detail", MasterDetailView.class, LineAwesomeIcon.COLUMNS_SOLID.create()));
        nav.addItem(new SideNavItem("Collaborative Master-Detail", CollaborativeMasterDetailView.class,
                LineAwesomeIcon.COLUMNS_SOLID.create()));
        nav.addItem(new SideNavItem("Person Form", PersonFormView.class, LineAwesomeIcon.USER.create()));
        nav.addItem(new SideNavItem("Address Form", AddressFormView.class, LineAwesomeIcon.MAP_MARKER_SOLID.create()));
        nav.addItem(
                new SideNavItem("Credit Card Form", CreditCardFormView.class, LineAwesomeIcon.CREDIT_CARD.create()));
        nav.addItem(new SideNavItem("Spreadsheet", SpreadsheetView.class, LineAwesomeIcon.FILE_EXCEL.create()));
        nav.addItem(new SideNavItem("Chat", ChatView.class, LineAwesomeIcon.COMMENTS.create()));
        nav.addItem(new SideNavItem("Page Editor", PageEditorView.class, LineAwesomeIcon.EDIT.create()));
        nav.addItem(new SideNavItem("Image Gallery", ImageGalleryView.class, LineAwesomeIcon.TH_LIST_SOLID.create()));
        nav.addItem(new SideNavItem("Checkout Form", CheckoutFormView.class, LineAwesomeIcon.CREDIT_CARD.create()));
        nav.addItem(
                new SideNavItem("Grid with Filters", GridwithFiltersView.class, LineAwesomeIcon.FILTER_SOLID.create()));

        return nav;
    }

    private Footer createFooter() {
        Footer layout = new Footer();

        return layout;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        viewTitle.setText(getCurrentPageTitle());
    }

    private String getCurrentPageTitle() {
        PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
        return title == null ? "" : title.value();
    }
}
