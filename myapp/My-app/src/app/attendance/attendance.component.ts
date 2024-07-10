import { Component } from '@angular/core';

interface Attendance {
  date: string;
  clockIn: string;
  clockOut: string;
  status: string;
}

@Component({
  selector: 'app-attendance',
  templateUrl: './attendance.component.html',
  styleUrl: './attendance.component.css'
})
export class AttendanceComponent {


username = '';
newAttendance: Attendance = {
  date: '',
  clockIn: '',
  clockOut: '',
  status: 'present'
};

addAttendance() {
  console.log('New Attendance:', this.newAttendance);
  // Add your logic to save the attendance here
  this.resetNewAttendance();
}

private resetNewAttendance() {
  this.newAttendance = {
    date: '',
    clockIn: '',
    clockOut: '',
    status: 'present'
  };
}

}
