# 📋 ToDoList - Android Task Manager App

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/)
[![Java](https://img.shields.io/badge/Language-Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Jetpack](https://img.shields.io/badge/Android%20Jetpack-MVVM-4285F4?style=for-the-badge&logo=google&logoColor=white)](https://developer.android.com/jetpack)
[![Room Database](https://img.shields.io/badge/Room-SQLite%20Persistence-FA7343?style=for-the-badge&logo=sqlite&logoColor=white)](https://developer.android.com/training/data-storage/room)
[![License](https://img.shields.io/badge/License-MIT-green.svg?style=for-the-badge)](LICENSE)

A clean, responsive, and robust **Android To-Do & Task Management Application** built using **Java**, **Android Jetpack components (MVVM)**, and **Room Database** for seamless offline persistence. 

Designed as a personal hobby project to practice modern Android architecture, reactive data streams, and intuitive gesture-driven UI interactions.

---

## ✨ Features

- 📝 **Create & Manage Tasks**: Quick task entry with distinct titles and detailed descriptions.
- 💾 **Offline-First Persistence**: Powered by Android's **Room Database** (SQLite abstraction) for reliable local storage that works seamlessly without internet.
- ⚡ **Reactive UI with LiveData**: Instant UI synchronization whenever tasks are added, modified, or deleted without manual refreshes.
- 🚀 **High-Performance RecyclerView**: Utilizes `ListAdapter` and `DiffUtil` for asynchronous diffing and buttery-smooth list rendering.
- 👈👉 **Swipe-to-Delete Gestures**: Intuitive swipe left/right gestures enabled via `ItemTouchHelper` to quickly dismiss completed tasks.
- 🎨 **Modern Material UI**: Clean Card-based layouts, Floating Action Button (FAB) interaction, and splash screen flow.
- 🛡️ **ViewBinding Integration**: Eliminates `findViewById` boilerplate with compile-time type safety.

---

## 🏗️ Architecture & Tech Stack

This project follows Google's recommended **MVVM (Model-View-ViewModel)** architectural pattern with the **Repository Pattern** to ensure separation of concerns, testability, and clean code maintainability.

```
┌──────────────────────────────────────────────┐
│                  View (UI)                   │
│   MainActivity   │   DataInsertActivity      │
└──────────────────────┬───────────────────────┘
                       │ Observes LiveData
                       ▼
┌──────────────────────────────────────────────┐
│                  ViewModel                   │
│               NoteViewModel                  │
└──────────────────────┬───────────────────────┘
                       │ Calls Data Operations
                       ▼
┌──────────────────────────────────────────────┐
│                  Repository                  │
│                   NoteRepo                   │
└──────────────────────┬───────────────────────┘
                       │ Queries / Inserts / Deletes
                       ▼
┌──────────────────────────────────────────────┐
│             Room Database (DAO)              │
│         NoteDatabase  │  NoteDao             │
└──────────────────────┬───────────────────────┘
                       │ SQLite Storage
                       ▼
┌──────────────────────────────────────────────┐
│              Local SQLite DB                 │
└──────────────────────────────────────────────┘
```

### 🛠️ Tech Stack & Libraries

| Component | Technology | Description |
|---|---|---|
| **Language** | Java (JDK 17 target) | Core application logic |
| **Architecture** | MVVM + Repository | Clean separation of business logic and presentation |
| **Local Database** | Android Room (`2.5.0`) | SQLite object mapping with compile-time verification |
| **Reactive UI** | `LiveData` & `ViewModel` | Lifecycle-aware reactive UI data binding |
| **View Layer** | `ViewBinding` | Null-safe and type-safe view binding |
| **List Management** | `RecyclerView` + `ListAdapter` | Asynchronous list diffing with `DiffUtil` |
| **Gestures** | `ItemTouchHelper` | Bidirectional swipe-to-delete support |
| **Build Tool** | Gradle Kotlin DSL (`kts`) | Compile SDK 34 / Min SDK 24 |

---

## 📂 Project Structure

```text
ToDoList/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/todolist/
│   │   │   │   ├── MainActivity.java        # Main dashboard displaying task list
│   │   │   │   ├── DataInsertActivity.java  # Form for adding new notes/tasks
│   │   │   │   ├── SpActivity.java          # Splash screen activity
│   │   │   │   ├── Note.java                # Room Entity data model
│   │   │   │   ├── NoteDao.java             # Room Data Access Object (DAO)
│   │   │   │   ├── NoteDatabase.java        # Room Database singleton instance
│   │   │   │   ├── NoteRepo.java            # Repository managing background tasks
│   │   │   │   ├── NoteViewModel.java       # Jetpack ViewModel exposing LiveData
│   │   │   │   └── RVAdapter.java           # ListAdapter implementation with DiffUtil
│   │   │   ├── res/
│   │   │   │   ├── layout/                  # XML UI layout definitions
│   │   │   │   ├── values/                  # Colors, themes, and strings
│   │   │   │   └── drawable/                # Vector assets and icons
│   │   │   └── AndroidManifest.xml          # App manifests and activity declarations
│   │   └── test/                            # Unit tests
│   └── build.gradle.kts                     # App module dependencies and configurations
├── build.gradle.kts                         # Root build configuration
├── settings.gradle.kts                      # Gradle settings & plugins
└── README.md                                # Project documentation
```

---

## 🚀 Getting Started

### Prerequisites

- **Android Studio** (Hedgehog, Iguana, or later recommended)
- **JDK 17**
- **Android Device or Emulator** running **Android 7.0 (API Level 24)** or higher

### Installation & Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/Yuvraj9198/ToDoList.git
   cd ToDoList
   ```

2. **Open in Android Studio**:
   - Launch Android Studio.
   - Select **Open an Existing Project** and choose the cloned folder.
   - Wait for Gradle sync to complete.

3. **Build & Run**:
   - Select an emulator or connected physical Android device.
   - Click the green **Run (▶)** button in Android Studio, or execute from the terminal:
     ```bash
     ./gradlew assembleDebug
     ```

---

## 💡 How It Works

1. **Adding a Task**:
   - Tap the floating action button (`+`) on the home screen.
   - Enter a title and description in `DataInsertActivity`.
   - Tap add — the task is saved to SQLite via the Room Repository on an asynchronous thread, and `LiveData` automatically triggers the `RecyclerView` to display the new item.

2. **Deleting a Task**:
   - Swipe any task card to either the left or right.
   - The `ItemTouchHelper` triggers `noteViewModel.delete(note)`, removing it immediately from the database with smooth removal animations.

---

## 🔮 Future Enhancements

- [ ] Task categories and color-coded priority labels (High, Medium, Low).
- [ ] Task edit/update functionality on item click.
- [ ] Due dates and local push notifications for reminders.
- [ ] Dark Mode toggle support.
- [ ] Search and filter options for quick note discovery.

---

## 👤 Author

Developed by **[Yuvraj](https://github.com/Yuvraj9198)**  
- 🌐 GitHub: [@Yuvraj9198](https://github.com/Yuvraj9198)

---

## 📄 License

This project is licensed under the [MIT License](LICENSE) — free to use for educational and personal hobby projects.
