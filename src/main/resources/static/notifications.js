document.addEventListener('DOMContentLoaded', () => {
    const lawyerId = '1'; // 실제 변호사 ID로 교체
    const eventSource = new EventSource(`/lawyers/${lawyerId}/notice`);
    const notificationList = document.getElementById('notificationList');

    eventSource.onmessage = function(event) {
        const reservation = JSON.parse(event.data);
        console.log('New reservation:', reservation);
        displayNotification(reservation);
    };

    eventSource.onerror = function(event) {
        console.error('EventSource failed:', event);
    };

    function displayNotification(reservation) {
        const notificationDiv = document.createElement('div');
        notificationDiv.classList.add('notification');
        notificationDiv.innerHTML = `
            <strong>New Reservation</strong><br>
            <strong>User ID:</strong> ${reservation.userId}<br>
            <strong>Date:</strong> ${reservation.date}<br>
            <strong>Time:</strong> ${reservation.startTime} - ${reservation.endTime}
        `;
        notificationList.prepend(notificationDiv);
    }
});