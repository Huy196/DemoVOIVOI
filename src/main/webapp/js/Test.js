document.addEventListener("DOMContentLoaded", function () {
    const openButton = document.getElementById("openOverlay");
    const closeButton = document.getElementById("closeOverlay");
    const overlay = document.getElementById("overlay");
    const iframe = document.getElementById("iframeOverlay");

    // Hiển thị overlay
    openButton.addEventListener("click", function () {
        alert("hehe")
        iframe.src = "Test/Hehe.jsp";
        overlay.style.display = "block";
    });

    // Đóng overlay
    closeButton.addEventListener("click", function () {
        overlay.style.display = "none"; // Ẩn overlay
        iframe.src = "";
    });
});
