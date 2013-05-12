profile-service-provider
========================

User Profile Service Provider
============================

Summary :
The User Profile service application stores information about users in a central location. Social computing features use this information to enable productive interactions so that users can collaborate efficiently. In order to provision My Sites, enable social computing features such as social tagging and newsfeeds, and create and distribute profiles across multiple sites and farms, you must enable the User Profile service application.

Features :


    User profiles – contain detailed information about people in an organization. A user profile organizes and displays all of the properties related to each user, together with social tags, documents, and other items related to that user.

    Profile synchronization – provides a reliable way to synchronize groups and user profile information that is stored in the SharePoint Server 2013 profile database together with information that is stored in directory services across the enterprise.

    Audiences – enables organizations to target content to users based on their job or task, as defined by their membership in a SharePoint Server group or distribution list, by the organizational reporting structure, or by the public properties in their user profiles.

    My Site Host – a dedicated site for hosting My Sites. A My Site Host is needed in order to deploy the social features of SharePoint Server.

    My Site – a personal site that gives users in your organization a central location to manage and store documents, links, and information about colleagues.

    Social tags and notes – enables users to add social tags to documents, to other SharePoint Server items, and to other items, such as external web pages and blog posts. Users can also leave notes on profile pages of a My Site or any SharePoint Server page. Administrators can delete all tags for employees when they leave the company or remove a tag they do not want.


Architecture :


Profile database – used to store user profile information.


Search Service application – needed to enable the People Search feature. For more information, see Understand/Plan people search.


Business Connectivity Services – makes it possible to populate the properties of existing user profiles from a business system during profile synchronization. For more information, see Overview of profile synchronization

Operations :

Create, edit, or delete User Profile service applications

delegate administration of a User Profile service application to a service application administrator

 remove a service application administrator from a User Profile service application


 Add, edit, or delete custom properties

 Manage user profile synchronization
