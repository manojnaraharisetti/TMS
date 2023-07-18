 document.addEventListener("DOMContentLoaded", function () {
  var current_fs, next_fs, previous_fs; // fieldsets
  var current = 1;
  var steps = document.querySelectorAll("fieldset").length;

  setProgressBar(current);

  document.querySelectorAll(".next").forEach(function (element) {
    element.addEventListener("click", function () {
      current_fs = this.parentElement;
      next_fs = this.parentElement.nextElementSibling;

      // Add Class Active
      document.querySelectorAll("li").forEach(function (item, index) {
        if (
          index ===
          Array.prototype.indexOf.call(
            document.querySelectorAll("fieldset"),
            next_fs
          )
        ) {
          item.classList.add("active");
        }
      });

      // Show the next fieldset
      next_fs.style.display = "block";
      next_fs.style.left = "-100%";

      // Hide the current fieldset with style
      var animationInterval = 500;
      var animationStep = 20;
      var currentLeft = 0;
      var nextLeft = -100;

      var animation = setInterval(function () {
        currentLeft += 100 / (animationInterval / animationStep);
        nextLeft += 100 / (animationInterval / animationStep);

        current_fs.style.left = currentLeft + "%";
        next_fs.style.left = nextLeft + "%";

        if (currentLeft >= 100) {
          clearInterval(animation);
          current_fs.style.display = "none";
        }
      }, animationStep);

      setProgressBar(++current);
    });
  });

  document.querySelectorAll(".previous").forEach(function (element) {
    element.addEventListener("click", function () {
      current_fs = this.parentElement;
      previous_fs = this.parentElement.previousElementSibling;

      // Remove class active
      document.querySelectorAll("li").forEach(function (item, index) {
        if (
          index ===
          Array.prototype.indexOf.call(
            document.querySelectorAll("fieldset"),
            current_fs
          )
        ) {
          item.classList.remove("active");
        }
      });

      // Show the previous fieldset
      previous_fs.style.display = "block";
      previous_fs.style.left = "100%";

      // Hide the current fieldset with style
      var animationInterval = 500;
      var animationStep = 20;
      var currentLeft = 0;
      var previousLeft = 100;

      var animation = setInterval(function () {
        currentLeft -= 100 / (animationInterval / animationStep);
        previousLeft -= 100 / (animationInterval / animationStep);

        current_fs.style.left = currentLeft + "%";
        previous_fs.style.left = previousLeft + "%";

        if (currentLeft <= -100) {
          clearInterval(animation);
          current_fs.style.display = "none";
        }
      }, animationStep);

      setProgressBar(--current);
    });
  });

  function setProgressBar(curStep) {
    var percent = (100 / steps) * curStep;
    percent = percent.toFixed();
    document.querySelector(".progress-bar").style.width = percent + "%";
  }

  document.querySelector(".submit").addEventListener("click", function () {
    return false;
  });
});