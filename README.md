# Shopping List App

This is a Shopping List application built with **Android Jetpack Compose**. The app allows users to create and manage a shopping list with features such as marking items as bought, adding new items, editing existing ones, and removing items individually or all at once. The app leverages **Room** for data persistence and features a simple navigation system.

## Features

1. **Splash Screen**: The app starts with a splash screen that displays a custom logo for 3 seconds before navigating to the main shopping list screen.
2. **Shopping List View**:
   - Items are displayed in a `LazyColumn` with an icon based on their category.
   - Each item shows:
     - **Icon**: An image corresponding to the item category.
     - **Name**: The name of the item.
     - **Description**: Additional details about the item.
     - **Price**: The estimated cost.
     - **Status Checkbox**: Indicates whether the item has been bought. Users can toggle this status.
   - **Total Price**: Displayed at the top, showing the sum of all item prices.
3. **Adding New Items**:
   - A `FloatingActionButton` opens a dialog for adding a new item.
   - Users can input the item name, price, description, and select a category.
   - **Validation**: Ensures fields are not left empty.
4. **Editing and Deleting Items**:
   - Users can edit item details using the edit button.
   - Items can be deleted individually using a delete button or all at once through a menu option.
5. **Data Persistence**:
   - The app uses **Room** to save and retrieve shopping list data.

## Technologies Used

- **Jetpack Compose**: For UI design.
- **Navigation Component**: For handling navigation between the splash and shopping list screens.
- **Room**: For data persistence and storage.
- **ViewModel**: To manage UI-related data in a lifecycle-conscious way.
- **State Management**: Using Compose's state hoisting.

## Extra Features

- **Error Handling**: Users are notified if fields are left empty while adding or editing items.
- **Additional Attributes**: The app can be extended with features like item detail view or sorting items by price.

## Screenshots
<img width="442" alt="Screenshot 2024-11-17 at 7 51 15 PM" src="https://github.com/user-attachments/assets/c93256ef-937e-440a-ad51-a06d112c500d">
<img width="335" alt="Screenshot 2024-11-17 at 7 50 53 PM" src="https://github.com/user-attachments/assets/b1f413e8-5233-498f-856a-2949315fba67">


