/* ============================================================
   PARKING SYSTEM — Login Logic
   File: login.js
   ============================================================ */

/* ============================================================
   STATE
   ============================================================ */
let role = 'user'; // 'user' | 'admin'

/* ============================================================
   ROLE TOGGLE
   ============================================================ */
function setRole(r, el) {
  role = r;
  document.querySelectorAll('.role-btn').forEach(btn => btn.classList.remove('active'));
  el.classList.add('active');
}

/* ============================================================
   SHOW / HIDE PASSWORD
   ============================================================ */
function togglePw() {
  const input = document.getElementById('pw');
  const btn   = document.getElementById('eyeBtn');
  input.type      = input.type === 'password' ? 'text' : 'password';
  btn.textContent = input.type === 'password'  ? '👁'   : '🙈';
}

/* ============================================================
   STATUS MESSAGE HELPER
   ============================================================ */
function showStatus(msg, isOk) {
  const el = document.getElementById('status');
  el.textContent = msg;
  el.className   = 'status show' + (isOk ? ' ok' : '');
  if (!isOk) setTimeout(() => el.classList.remove('show'), 3000);
}

/* ============================================================
   RIPPLE EFFECT HELPER
   ============================================================ */
function spawnRipple(target, event) {
  const ripple = document.createElement('span');
  ripple.className = 'ripple';
  const rect = target.getBoundingClientRect();
  const size = Math.max(target.offsetWidth, target.offsetHeight);
  ripple.style.cssText = `
    width:  ${size}px;
    height: ${size}px;
    left:   ${event.clientX - rect.left - size / 2}px;
    top:    ${event.clientY - rect.top  - size / 2}px;
  `;
  target.appendChild(ripple);
  setTimeout(() => ripple.remove(), 600);
}

/* ============================================================
   LOGIN HANDLER
   ============================================================ */
async function doLogin(event) {
  const btn = document.getElementById('btn');
  const cw  = document.getElementById('cw');

  /* ripple */
  spawnRipple(btn, event);

  /* read values */
  const username = document.getElementById('uname').value.trim();
  const password = document.getElementById('pw').value.trim();

  /* client-side validation */
  if (!username || !password) {
    cw.classList.remove('shake');
    void cw.offsetWidth; // force reflow to restart animation
    cw.classList.add('shake');
    setTimeout(() => cw.classList.remove('shake'), 500);
    showStatus('⚠ Fill in both fields', false);
    return;
  }

  /* loading state */
  btn.textContent         = 'CHECKING...';
  btn.style.pointerEvents = 'none';

  /* ==========================================================
     BACKEND API CALL — wire your Java backend here
     ==========================================================

     Your Java backend should expose a POST endpoint, e.g.:
       POST http://localhost:8080/api/login
       Content-Type: application/json
       Body: { "username": "...", "password": "...", "role": "user" | "admin" }

     Expected JSON response:
       Success → { "success": true,  "token": "...", "message": "Welcome" }
       Failure → { "success": false, "message": "Invalid credentials" }

     Uncomment the block below when your API is ready:
     ---------------------------------------------------------- */

  // try {
  //   const res = await fetch('http://localhost:8080/api/login', {
  //     method: 'POST',
  //     headers: { 'Content-Type': 'application/json' },
  //     body: JSON.stringify({ username, password, role })
  //   });
  //
  //   const data = await res.json();
  //
  //   if (data.success) {
  //     localStorage.setItem('token', data.token);
  //     localStorage.setItem('role',  role);
  //     window.location.href = role === 'admin' ? 'admin-dashboard.html' : 'dashboard.html';
  //   } else {
  //     cw.classList.remove('shake');
  //     void cw.offsetWidth;
  //     cw.classList.add('shake');
  //     setTimeout(() => cw.classList.remove('shake'), 500);
  //     showStatus('✖ ' + (data.message || 'Wrong credentials'), false);
  //     btn.innerHTML           = 'ROLL IN &nbsp;→';
  //     btn.style.pointerEvents = 'auto';
  //   }
  // } catch (err) {
  //   showStatus('✖ Server unreachable. Try again.', false);
  //   btn.innerHTML           = 'ROLL IN &nbsp;→';
  //   btn.style.pointerEvents = 'auto';
  // }

  /* ==========================================================
     DEMO MODE — delete this block once backend is connected
     ========================================================== */
  setTimeout(() => {
    btn.innerHTML           = '✓ ACCESS GRANTED &nbsp;→';
    btn.classList.add('success');
    btn.style.pointerEvents = 'auto';
    showStatus(`🚗 Welcome, ${username}! Find your slot.`, true);
    // TODO: uncomment redirect once dashboard is ready
    // window.location.href = role === 'admin' ? 'admin-dashboard.html' : 'dashboard.html';
  }, 900);
  /* ========================================================== */
}

/* ============================================================
   ENTER KEY SUPPORT
   ============================================================ */
document.addEventListener('keydown', (e) => {
  if (e.key === 'Enter') document.getElementById('btn').click();
});
