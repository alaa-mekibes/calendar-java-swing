# Calendar Management System - Project Summary

## Project Overview
A Java Swing-based **Calendar Management System** with role-based access control, event management, team collaboration, and notification system.

---

## System Actors

### 1. **OWNER** (System Administrator)
**Description:** The highest authority in the system with complete control over all resources.

**Key Permissions:**
- ✅ Create teams
- ✅ Create events
- ✅ Update events
- ✅ Delete events
- ✅ Manage all users (assign roles, teams)
- ✅ View all events (system-wide)
- ✅ Access Users panel for user management
- ✅ Access Teams panel
- ✅ View/restore deleted events from trash
- ✅ Receive all notifications

**Interface:**
- `HomeAdminView` - Main dashboard
- Full access to all panels and dialogs
- Keyboard shortcuts: Ctrl+N (create event), Ctrl+T (create team)

---

### 2. **ADMIN** (Team Manager/Administrator)
**Description:** Manages team operations and events, with restrictions on system-wide changes.

**Key Permissions:**
- ✅ Create events
- ✅ Update events
- ✅ Delete events
- ✅ View **only their team's events**
- ✅ Manage team members (assign users to team)
- ✅ Access team calendar
- ✅ Access user management within their scope
- ✅ Cannot create teams (OWNER only)

**Interface:**
- `HomeAdminView` - Main dashboard
- Access to calendar, teams, notifications, users, trash panels
- Filtered calendar views (team-specific)

---

### 3. **DEV** (Developer/Team Member)
**Description:** Team members who can view team events in read-only mode.

**Key Permissions:**
- ✅ View **only their team's events** (READ-ONLY)
- ✅ View event details
- ✅ View team calendar
- ✅ View/update personal profile
- ✅ Receive notifications
- ❌ Cannot create events
- ❌ Cannot update events
- ❌ Cannot delete events

**Interface:**
- `HomeDevView` - Limited dashboard
- Access to: Calendar (read-only), Profile, Notifications, Help, Logout
- Cannot access: Event creation, Event editing, User management, Team creation, Trash

---

## Key Features & Scenarios

### **Authentication & Authorization**
| Scenario | Actor | Flow |
|----------|-------|------|
| **Register Account** | Any User | Navigate → Register → Enter details → Create account with DEV role (default) |
| **Login** | Registered User | Enter email/password → System validates → Redirects to appropriate dashboard |
| **Automatic Dashboard Selection** | System | After login: OWNER/ADMIN → HomeAdminView, DEV → HomeDevView |

### **Event Management**

#### Create Event
| Actor | Steps | Constraints |
|-------|-------|-------------|
| OWNER/ADMIN | Click "Create Event" or Ctrl+N → Fill details → Select team → Save | Must belong to a team (except OWNER) |
| | Notifications sent to: Team members + Owner | - |
| DEV | ❌ No access | Cannot create events |

#### Update Event
| Actor | Steps | Constraints |
|-------|-------|-------------|
| OWNER | Select event → Update details → Save | Can update any event |
| ADMIN | Select **team event only** → Update → Save | Only their team's events |
| DEV | ❌ No access | Cannot update events (read-only) |

#### Delete Event
| Actor | Steps | Constraints |
|-------|-------|-------------|
| OWNER | Select event → Delete → Moved to trash | Can restore from trash |
| ADMIN | Delete **team event** → Moved to trash | Only their team's events |
| DEV | ❌ No access | Cannot delete events |

#### View Calendar

**OWNER/ADMIN (HomeAdminView):**
- Monthly calendar with all events
- Daily detailed view (24-hour slots)
- Drag-and-drop events to reschedule
- Events color-coded by team

**DEV (HomeDevView):**
- Monthly calendar with **team-only events** (READ-ONLY)
- Daily calendar with **team-only events** (READ-ONLY)
- Can click to view event details
- Cannot create, edit, or drag events

---

### **Team Management**

#### Create Team
| Actor | Permission |
|-------|-----------|
| OWNER ✅ | Can create, name, assign color, add members |
| ADMIN ❌ | Cannot create teams |
| DEV ❌ | Cannot create teams |

#### Manage Team Members
| Actor | Capabilities |
|-------|-------------|
| OWNER | Add/remove users to teams, assign roles |
| ADMIN | View team members, manage within team scope |
| DEV | View team members (read-only) |

---

### **User Management**

#### View Users
| Actor | Access |
|-------|--------|
| OWNER | View all users, edit roles, edit teams, delete users |
| ADMIN | View users in their team |
| DEV | Cannot access Users panel |

#### Update User Profile
| Actor | Updates |
|-------|---------|
| All | Can update own: Name, Email, Password |
| OWNER | Can update any user's: Name, Email, Password, Role, Team |

---

### **Notification System**

#### Notification Types
1. **EVENT_CREATED** - When event is created
2. **EVENT_UPDATED** - When event is modified
3. **EVENT_DELETED** - When event is deleted
4. **EVENT_RESTORED** - When event is restored from trash

#### Notification Recipients
| Action | Recipients |
|--------|-----------|
| Create event | OWNER + All team members |
| Update event | OWNER + All team members |
| Delete event | OWNER only |
| Restore event | OWNER only |

#### View Notifications
- DEV: Can view notifications in Notification panel
- ADMIN: Can view notifications
- OWNER: Receives all system notifications

---

### **Calendar Views**

#### Admin/Owner Calendar (HomeAdminView)
**Monthly View:**
- Displays all events (system-wide for OWNER, team-filtered for ADMIN)
- Events color-coded by team
- Click day to see all events
- Drag-and-drop to reschedule

**Daily View (24-hour):**
- Hourly slots
- Hover effect on hours
- Click event to view details
- Drag-and-drop events

**Features:**
- Navigate months with prev/next
- Go to today button
- Create event shortcut

#### Developer Calendar (HomeDevView)
**Monthly View:**
- Displays **team-only events**
- Read-only (cannot drag)
- Filter by user's team automatically
- Click to view event details

**Daily View:**
- 24-hour view of team events only
- Cannot drag-and-drop
- View event details on click

---

### **Trash & Recovery**

#### Delete Event Flow
| Step | Detail |
|------|--------|
| 1 | User deletes event |
| 2 | Event moved to `deletedEvents` list |
| 3 | Notification sent to OWNER |
| 4 | Event appears in Trash panel |
| 5 | OWNER can restore or permanently delete |

#### Restore Event
- Only accessible from Trash panel
- OWNER only
- Moves event back to active events
- Notification sent when restored

---

## Model Architecture

### **Core Models**

```
User
├── id (int)
├── username (String)
├── email (String)
├── password (String)
├── role (Role: OWNER, ADMIN, DEV)
└── team (Team reference)

Team
├── id (int)
├── name (String)
├── description (String)
├── color (Color)
└── devs (List<User>)

Event
├── id (int)
├── title (String)
├── description (String)
├── team (String - team name)
├── date (LocalDate)
├── startTime (LocalTime)
├── endTime (LocalTime)
└── color (Color - inherited from team)

Notification
├── message (String)
├── recipientUserId (int)
├── timestamp (LocalDateTime)
└── type (NotificationTypes)

Role (Enum)
├── OWNER
├── ADMIN
└── DEV
```

---

## Controllers

| Controller | Responsibilities |
|-----------|------------------|
| **AuthController** | Login, Register, User authentication |
| **EventController** | CRUD operations for events, filtering by date/team |
| **TeamController** | Create/update/delete teams, manage members |
| **UserController** | User management, role/team assignment |
| **NotificationController** | Create notifications, notify users/teams |

---

## View Structure

### **Authentication**
- `Login.java` - Login interface
- `Register.java` - Registration interface

### **Main Views**
- `HomeAdminView.java` - Admin/Owner dashboard
- `HomeDevView.java` - Developer dashboard

### **Panels** (Reusable components)
- `MonthlyCalendarPanel.java` - Full calendar view (Owner/Admin)
- `MonthlyCalendarForDevsPanel.java` - Team-filtered calendar (Dev)
- `DailyCalendarForAdminsPanel.java` - 24-hour view (Admin/Owner)
- `DailyCalendarForDevsPanel.java` - Team-filtered 24-hour view (Dev)
- `TeamPanel.java` - Team management
- `UsersPanel.java` - User management
- `ProfilePanel.java` - User profile editing
- `NotificationPanel.java` - View notifications
- `TrashPanel.java` - Deleted events recovery
- `HelpPanel.java` - Help/documentation

### **Dialogs** (Pop-up windows)
- `CreateEventDialog.java` - Create new event
- `UpdateEventDialog.java` - Edit existing event
- `CreateTeamDialog.java` - Create new team
- `UpdateTeamDialog.java` - Edit team
- `UpdateUserDialog.java` - Edit user details
- `ShowEventDetailsDialog.java` - View event full details

---

## Data Persistence

**Storage:** `DataStorage.java`
- Serialized Java objects (`data.ser`)
- Single file-based persistence
- Auto-loads on app start
- Auto-saves on changes

**Data Saved:**
1. Users list
2. Teams list
3. Events list
4. Deleted events list
5. Notifications list

---

## Access Control Summary

### **Event Visibility**
```
OWNER:  ✅ All events (system-wide)
ADMIN:  ✅ Team events only
DEV:    ✅ Team events only
```

### **Calendar Editing**
```
OWNER:  ✅ Drag-drop, create, update, delete
ADMIN:  ✅ Drag-drop, create, update, delete (team events only)
DEV:    ❌ Read-only view only (cannot create, edit, or drag)
```

### **User Management**
```
OWNER:  ✅ Full access (create, update, delete, roles)
ADMIN:  ✅ Limited (view, manage team users)
DEV:    ❌ Cannot access
```

### **Team Management**
```
OWNER:  ✅ Create, update, delete, manage members
ADMIN:  ✅ Manage members in existing teams
DEV:    ❌ View only (read-only)
```

---

## Key Scenarios

### **Scenario 1: Owner Creates Event for Team**
1. Owner logs in → HomeAdminView
2. Clicks "Create Event" or Ctrl+N
3. Enters: Title, Description, Team, Date, Time
4. System creates event
5. Notifications sent to: Owner + All team members
6. Event visible in calendar (color-coded by team)

### **Scenario 2: Developer Views Team Calendar (Read-Only)**
1. Dev logs in → HomeDevView
2. Clicks "Calendar"
3. System displays: MonthlyCalendarForDevsPanel
4. Only team events visible (auto-filtered)
5. Dev can click event to view details (read-only)
6. ❌ Cannot create, edit, or drag events

### **Scenario 3: Admin Updates Team Event**
1. Admin logs in → HomeAdminView
2. Navigates to team event in calendar
3. Clicks event → Update dialog
4. Modifies details (date, time, etc.)
5. Saves changes
6. Notifications sent to: Owner + All team members
7. Event updated in calendar

### **Scenario 4: Owner Restores Deleted Event**
1. Owner deletes event → Moved to trash
2. Owner clicks "Trash" panel
3. Sees deleted events
4. Clicks "Restore" button
5. Event moves back to active calendar
6. Notification sent to team

### **Scenario 5: Admin Invites User to Team**
1. Admin logs in → HomeAdminView
2. Clicks "Teams" panel
3. Selects team → "Manage Members"
4. Adds user to team
5. User's team assignment updated
6. User can now see team events in their calendar

---

## Summary

This **Calendar Management System** implements:
- ✅ **Role-Based Access Control** (3 roles: Owner, Admin, Dev)
- ✅ **Team-Scoped Event Management** (Team filtering)
- ✅ **Drag-and-Drop Scheduling** (Admin/Owner only)
- ✅ **Multi-User Notifications** (Event-based)
- ✅ **Data Persistence** (File-based storage)
- ✅ **User Management** (Role assignment)
- ✅ **Soft Deletes** (Trash/Recovery)

**Total Actors:** 3 (Owner, Admin, Developer)  
**Key Features:** 10+ (Events, Teams, Users, Notifications, Trash, etc.)  
**UI Views:** 2 main + 8 panels + 6 dialogs  
**Dev Access:** View-only (Read-only calendar, cannot create/edit/delete events)
